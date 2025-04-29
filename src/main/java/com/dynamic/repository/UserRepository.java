package com.dynamic.repository;

import com.dynamic.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findAll();

    User findByUsername(String username);
}
