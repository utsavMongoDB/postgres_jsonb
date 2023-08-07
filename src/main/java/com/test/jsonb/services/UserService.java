package com.test.jsonb.services;

import com.test.jsonb.dto.UserDto;
import com.test.jsonb.mapper.Mapper;
import com.test.jsonb.models.Order;
import com.test.jsonb.models.User;
import com.test.jsonb.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private Mapper mapper;

    public String saveUsers(Long userId) {
        System.out.println(userId);
        UserDto userDto = generateUserDto(userId);
        User entity = mapper.toUser(userDto);
        System.out.println(entity.toString());
        userRepo.save(entity);
        return "Added User Successfully";
    }

    private static final String[] EMAIL_DOMAINS = {"example.com", "test.com", "domain.com", "user.com"};

    public static UserDto generateUserDto(Long userId) {
        String username = generateUsername(userId);
        String password = generatePassword();
        String email = username + "@" + EMAIL_DOMAINS[new Random().nextInt(EMAIL_DOMAINS.length)];

        UserDto userDto = new UserDto();
        userDto.setUser_id(userId);
        userDto.setUsername(username);
        userDto.setPassword(password);
        userDto.setEmail(email);

        return userDto;
    }

    private static String generateUsername(Long userId) {
        return "user" + userId;
    }

    private static String generatePassword() {
        return "Pass" + new Random().nextInt(100000);
    }

}
