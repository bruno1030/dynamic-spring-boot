package com.dynamic.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private Boolean isInternal;

    private Integer roleId;

}
