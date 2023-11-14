package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity // This tells Hibernate to make a table out of this class
public class UserDTO {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer  identifier;
    @Column
    private String id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;

    public UserDTO(){}
}