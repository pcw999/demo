package com.example.demo.entity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class ImageDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer post_id;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String img;
    @Column
    private String txt;

    public ImageDTO(){}
}
