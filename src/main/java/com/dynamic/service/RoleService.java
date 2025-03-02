package com.dynamic.service;

import com.dynamic.dto.RoleDto;
import com.dynamic.entity.Role;
import com.dynamic.mapper.RoleMapper;
import com.dynamic.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDto> getRoles(){

        List<Role> rolesList = roleRepository.findAll();

        List<RoleDto> roleDtoList = new ArrayList<>();

        for (Role role : rolesList) {
            if(role != null){
                roleDtoList.add(RoleMapper.toDto(role));
            }
        }

        return roleDtoList;
    }

    public Role createRole(Role role) {
        Role savedRole = roleRepository.save(role);
        return savedRole;
    }

    public Role updateRole(Role role) {
        Role updatedRole = roleRepository.save(role);
        return updatedRole;
    }

    public Role findRoleById(Integer id) {
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            return role.get();
        }
        return null;
    }

    public Role getRoleById(Integer roleId) {

        Optional<Role> role = roleRepository.findById(roleId);

        return role.get();
    }
}
