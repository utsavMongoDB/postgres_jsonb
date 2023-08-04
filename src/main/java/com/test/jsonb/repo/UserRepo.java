package com.test.jsonb.repo;

import com.test.jsonb.models.Order;
import com.test.jsonb.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

}
