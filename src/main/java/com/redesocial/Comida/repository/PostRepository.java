package com.redesocial.Comida.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.redesocial.Comida.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
