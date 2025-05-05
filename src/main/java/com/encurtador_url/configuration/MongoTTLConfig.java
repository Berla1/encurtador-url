package com.encurtador_url.configuration;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Indexes;
import com.mongodb.client.model.IndexOptions;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoTTLConfig {

    @Bean
    public CommandLineRunner createTTLIndex(MongoTemplate mongoTemplate) {
        return args -> {
            MongoCollection<Document> collection = mongoTemplate.getCollection("urls");
            IndexOptions options = new IndexOptions().expireAfter(0L, java.util.concurrent.TimeUnit.SECONDS);
            collection.createIndex(Indexes.ascending("expiresAt"), options);
        };
    }
}