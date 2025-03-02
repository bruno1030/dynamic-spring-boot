package com.dynamic.controller;

import com.dynamic.dto.UserDto;
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
    public List<UserDto> getUsers(){
        List<UserDto> userDtoList = userService.getUsers();
        return userDtoList;
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody UserDto newUserDto){
        try{
            User savedUser = userService.createUser(UserMapper.toUser(newUserDto));
            UserDto savedUserDtoToResponse = UserMapper.toDto(savedUser);
            return new ResponseEntity<>(savedUserDtoToResponse, null, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error on creating user", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody UserDto updatedUserDto){
        try{
            User existingUser = userService.findUserById(id);
            if(existingUser != null){
                updatedUserDto.setId(id);
                User updatedUser = userService.updateUser(UserMapper.toUser(updatedUserDto));
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
    public ResponseEntity getUserById(@PathVariable Integer userId){
        try{
            User retrievedUser = userService.getUserById(userId);
            UserDto retrievedUserDto = UserMapper.toDto(retrievedUser);
            return new ResponseEntity<>(retrievedUser, null, HttpStatus.OK) ;
        }catch (Exception e){
            return new ResponseEntity<>("Error on getting the user by id", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
