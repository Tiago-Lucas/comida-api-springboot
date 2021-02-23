package com.redesocial.Comida.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.redesocial.Comida.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
