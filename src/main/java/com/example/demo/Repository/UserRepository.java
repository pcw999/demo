package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends CrudRepository<UserDTO, Integer> {
    List<UserDTO> findById(String Id);
    boolean existsById(String Id);

}