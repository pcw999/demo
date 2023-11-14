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

    public UserDTO(String name, String id, String password, String email) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String name) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}