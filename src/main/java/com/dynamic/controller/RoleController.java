package com.dynamic.controller;

import com.dynamic.dto.RoleDto;
import com.dynamic.dto.UserDto;
import com.dynamic.entity.Role;
import com.dynamic.entity.User;
import com.dynamic.mapper.RoleMapper;
import com.dynamic.mapper.UserMapper;
import com.dynamic.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity getRoles(){
        try{
            List<RoleDto> roleDtoList = roleService.getRoles();
            return new ResponseEntity<>(roleDtoList, null, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error on getting the list of roles", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity saveRole(@RequestBody RoleDto newRoleDto){
        try{
            Role savedRole = roleService.createRole(RoleMapper.toRole(newRoleDto));
            RoleDto savedRoleDtoToResponse = RoleMapper.toDto(savedRole);
            return new ResponseEntity<>(savedRoleDtoToResponse, null, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Error on creating role", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateRole(@PathVariable Integer id, @RequestBody RoleDto updatedRoleDto){
        try{
            Role existingRole = roleService.findRoleById(id);
            if(existingRole != null){
                updatedRoleDto.setId(id);
                Role updatedRole = roleService.updateRole(RoleMapper.toRole(updatedRoleDto));
                RoleDto updatedRoleDtoToResponse = RoleMapper.toDto(updatedRole);
                return new ResponseEntity<>(updatedRoleDtoToResponse, null, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Role not found", null, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Error on updating role", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{roleId}")
    public ResponseEntity getRoleById(@PathVariable("roleId") Integer roleId){
        try{
            Role retrievedRole = roleService.getRoleById(roleId);
            RoleDto retrievedRoleDto = RoleMapper.toDto(retrievedRole);
            return new ResponseEntity<>(retrievedRoleDto, null, HttpStatus.OK) ;
        }catch (Exception e){
            return new ResponseEntity<>("Error on getting the role by id", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
