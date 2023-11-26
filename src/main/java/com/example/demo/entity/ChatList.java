package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class ChatList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer idx;
    private String roomId;
    private String messageContent;
    private String timestamp;
    private boolean isRead; // 읽음 상태를 나타내는 필드 추가
    private Integer writer;
    private Integer reader;

    public ChatList() { }

    public void setRoom_id(String roomId) {
        this.roomId = roomId;
    }
}
