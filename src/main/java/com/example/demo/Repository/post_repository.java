package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.sample_post;
public interface post_repository extends CrudRepository<sample_post, Integer> {

}
