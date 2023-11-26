package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;

@Getter
@Entity
public class ChatCount {
    @Id
    private Integer identifier;
    private Integer last_cnt;
    private Integer room_cnt;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String room_id_list;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String room_user_list;


    public ChatCount() {}
    public ChatCount(Integer my_id, Integer opp_id, String opp_user) {
        this.identifier = my_id;
        this.last_cnt = 0;
        this.room_cnt = 1;
        this.room_id_list = Integer.toString(opp_id);
        this.room_user_list = opp_user;
    }

    public String[] get_user_list(){
        String[] room_user_list;
        room_user_list = this.room_user_list.split("/");
        return room_user_list;
    }

    public void add_user(Integer opp_id, String opp_user) {
        this.room_cnt+=1;
        this.room_id_list = this.room_id_list + "/" + opp_id;
        this.room_user_list = this.room_user_list + "/" + opp_user;
    }
}
