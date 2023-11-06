package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class new_post_save {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer post_id;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String img;
    private String txt;

    public new_post_save(){}
    public void set_post_save(String img, String text) {
        this.img = img;
        this.txt = text;
    }

    public String get_img() { return this.img; }
    public String get_txt() { return this.txt; }
}
