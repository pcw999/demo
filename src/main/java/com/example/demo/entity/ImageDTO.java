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
    public ImageDTO(String img, String text) {
        this.img = img;
        this.txt = text;
    }

    public String get_img() { return this.img; }
    public String get_txt() { return this.txt; }
}
