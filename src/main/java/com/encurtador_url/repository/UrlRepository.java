package com.encurtador_url.repository;

import com.encurtador_url.model.Url;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UrlRepository extends MongoRepository<Url, String> {
}