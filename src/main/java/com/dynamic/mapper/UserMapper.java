package com.dynamic.mapper;

import com.dynamic.dto.UserDto;
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

        return userDto;
    }

    public static User toUser(UserDto userDto){
        User user = new User();

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setIsInternal(userDto.getIsInternal());
        user.setRoleId(userDto.getRoleId());

        return user;
    }

}
