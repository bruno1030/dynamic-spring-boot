package com.dynamic.dto;

import com.dynamic.entity.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

@Getter
@Setter
public class UserDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String dateOfBirth;

    private int isInternal;

    private Integer roleId;

}
