package com.dynamic.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserRegistrationDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private Boolean isInternal;

    private Integer roleId;

    private String username;

    private String password;

}
