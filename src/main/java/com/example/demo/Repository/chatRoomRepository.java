package com.example.demo.Repository;

import com.example.demo.entity.ChatCount;
import com.example.demo.entity.ChatList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface chatRoomRepository extends CrudRepository<ChatCount, Integer> {
    ChatCount findByIdentifier(Integer identifier);
}
