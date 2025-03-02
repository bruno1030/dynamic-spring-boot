package com.dynamic.mapper;

import com.dynamic.dto.RoleDto;
import com.dynamic.entity.Role;

public class RoleMapper {

    public static RoleDto toDto(Role role){
        RoleDto roleDto = new RoleDto();

        roleDto.setId(role.getId());
        roleDto.setDescription(role.getDescription());

        return roleDto;
    }

    public static Role toRole(RoleDto roleDto){
        Role role = new Role();

        role.setId(roleDto.getId());
        role.setDescription(roleDto.getDescription());

        return role;
    }

}
