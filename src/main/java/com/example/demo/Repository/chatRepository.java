package com.example.demo.Repository;

import com.example.demo.entity.ChatList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface chatRepository extends CrudRepository<ChatList, Integer> {
    Iterable<ChatList> findByRoomId(String room_id);
    Iterable<ChatList> findByRoomIdAndIdxGreaterThan(String roomId, int idx);
}
