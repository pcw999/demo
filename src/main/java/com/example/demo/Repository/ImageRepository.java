package com.example.demo.Repository;

import com.example.demo.entity.ImageDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<ImageDTO, Integer> {
}
