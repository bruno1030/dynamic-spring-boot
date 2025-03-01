package com.dynamic.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("roles")
@Getter
@Setter
public class Role {

    @Id
    private Integer id;

    private String description;
}
