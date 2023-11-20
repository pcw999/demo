package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class ImageDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer post_id;
    private String post_owner;
    @Lob
    @Column(columnDefinition = "LONGBLOB", nullable = false)
    private String img;
    @Column
    private String txt;
    @Column
    private String date;

    public ImageDTO(){}

    public void setPost_owner(String post_owner){ this.post_owner = post_owner; }
}
