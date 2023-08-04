package com.test.jsonb.controllers;


import com.test.jsonb.dto.UserDto;
import com.test.jsonb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add/{user_id}")
    public String saveUser(@PathVariable Long user_id) {
        return userService.saveUsers(user_id);
    }
}
