package com.example.demo.Repository;

import com.example.demo.entity.ImageDTO;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<ImageDTO, Integer> {
}
