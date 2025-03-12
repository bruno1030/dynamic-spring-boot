package com.dynamic.controller;

import com.dynamic.dto.UserDto;
import com.dynamic.dto.UserRegistrationDto;
import com.dynamic.entity.User;
import com.dynamic.mapper.UserMapper;
import com.dynamic.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity getUsers(){
        try{
            List<UserDto> userDtoList = userService.getUsers();
            return new ResponseEntity<>(userDtoList, null, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error on getting the list of users", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserRegistrationDto newUserRegistrationDto){
        try{
            User savedUser = userService.createUser(newUserRegistrationDto);
            UserDto savedUserDtoToResponse = UserMapper.toDto(savedUser);
            return new ResponseEntity<>(savedUserDtoToResponse, null, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error on creating user", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody UserRegistrationDto updatedUserRegistrationDto){
        try{
            User existingUser = userService.findUserById(id);
            if(existingUser != null){
                updatedUserRegistrationDto.setId(id);
                User updatedUser = userService.updateUser(UserMapper.toUser(updatedUserRegistrationDto));
                UserDto updatedUserDtoToResponse = UserMapper.toDto(updatedUser);
                return new ResponseEntity<>(updatedUserDtoToResponse, null, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("User not found", null, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error on updating user", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer userId) {
        User retrievedUser = userService.getUserById(userId);
        UserDto retrievedUserDto = UserMapper.toDto(retrievedUser);
        return ResponseEntity.ok(retrievedUserDto);
    }

}
