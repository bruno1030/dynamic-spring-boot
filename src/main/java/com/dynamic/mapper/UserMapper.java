package com.dynamic.mapper;

import com.dynamic.dto.UserDto;
import com.dynamic.dto.UserRegistrationDto;
import com.dynamic.entity.User;

public class UserMapper {

    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setIsInternal(user.getIsInternal());
        userDto.setRoleId(user.getRoleId());
        userDto.setUsername(user.getUsername());

        return userDto;
    }

    public static User toUser(UserRegistrationDto userRegistrationDto){
        User user = new User();

        user.setId(userRegistrationDto.getId());
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setDateOfBirth(userRegistrationDto.getDateOfBirth());
        user.setIsInternal(userRegistrationDto.getIsInternal());
        user.setRoleId(userRegistrationDto.getRoleId());
        user.setUsername(userRegistrationDto.getUsername());
        user.setPassword(userRegistrationDto.getPassword());

        return user;
    }

}
