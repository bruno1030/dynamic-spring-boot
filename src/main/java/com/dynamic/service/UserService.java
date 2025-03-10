package com.dynamic.service;

import com.dynamic.dto.UserDto;
import com.dynamic.dto.UserRegistrationDto;
import com.dynamic.entity.User;
import com.dynamic.mapper.UserMapper;
import com.dynamic.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

    public User createUser(UserRegistrationDto newUserRegistrationDto) {

        User userToBeSaved = UserMapper.toUser(newUserRegistrationDto);

        userToBeSaved.setPassword(passwordEncoder.encode(userToBeSaved.getPassword()));

        return userRepository.save(userToBeSaved);
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
