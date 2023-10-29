package com.example.demo.entity;

// for json
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonProperty;

//for db
import jakarta.persistence.*;

@Entity
@JsonRootName("sample_post")
public class sample_post {
    @JsonProperty("post_id")
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @JsonProperty("user_id")
    private String oner;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    @JsonProperty("post_image")
    private String img;
    @JsonProperty("post_text")
    private String text;
    @JsonProperty("like")
    private Integer like_cnt;

    public sample_post() {
        this.oner = "sample_oner";
        this.img = "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";
        this.text = "Hello (sample)";
        this.like_cnt = 9999;
    }

    public void set_text(String text) { this.text = text; }

}
