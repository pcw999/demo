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
    private Integer identifier;

    @Column(unique = true, nullable = false)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String profileImg;
    @Column
    private String date;

    public Integer getIdentifier() {
        return identifier;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }


    public UserDTO(){}
}