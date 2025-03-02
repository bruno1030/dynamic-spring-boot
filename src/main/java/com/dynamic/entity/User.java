package com.dynamic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.time.LocalDate;

@Table("users")
@Getter
@Setter
public class User {

    @Id
    private Integer id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private Boolean isInternal;

    @Column("id_role")  // This maps to the 'id_role' column in the 'users' table
    private Integer roleId;

    @MappedCollection(idColumn = "id")  // This fetches the role
    private Role role;
}
