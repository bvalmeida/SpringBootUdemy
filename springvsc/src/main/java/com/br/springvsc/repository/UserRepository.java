package com.br.springvsc.repository;

import com.br.springvsc.entity.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User, Long> {

    @Query("{ 'email' : ?0}")
    User findeByEmailQualquerCoisa(String email);

    User findByNameIgnoreCaseLike(String name);

}
