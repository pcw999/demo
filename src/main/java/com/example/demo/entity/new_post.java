package com.example.demo.entity;

import lombok.Getter;

@Getter
public class new_post {
    private String img;
    private String txt;

    public String get_img() { return this.img; }
    public String get_txt() { return this.txt; }
}
