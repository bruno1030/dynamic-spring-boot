package com.dynamic.service;

import com.dynamic.dto.UserDto;
import com.dynamic.entity.User;
import com.dynamic.mapper.UserMapper;
import com.dynamic.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUsers(){

        List<User> usersList = userRepository.findAll();

        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : usersList) {
            if(user != null){
                userDtoList.add(UserMapper.toDto(user));
            }
        }

        return userDtoList;
    }

    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User updateUser(User user) {
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public User findUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    public User getUserById(Integer userId) {

        Optional<User> user = userRepository.findById(userId);

        return user.get();
    }
}
