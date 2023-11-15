package com.example.demo.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Entity // This tells Hibernate to make a table out of this class
public class UserDTO {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer  identifier;

    @Column(unique = true, nullable = false)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    public UserDTO(){}
}