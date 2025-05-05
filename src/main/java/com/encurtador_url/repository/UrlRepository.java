package com.encurtador_url.repository;

import com.encurtador_url.model.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;


public interface UrlRepository extends MongoRepository<Url, String> {
    @Query(value = "{'_id': ?0}", fields = "{'_id': 1}")
    Optional<Url> findUrlById(String id);
}