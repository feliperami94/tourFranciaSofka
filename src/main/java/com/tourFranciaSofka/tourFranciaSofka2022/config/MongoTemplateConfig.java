package com.tourFranciaSofka.tourFranciaSofka2022.config;

import com.mongodb.reactivestreams.client.MongoClient;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
@AllArgsConstructor
public class MongoTemplateConfig {
    private final MongoClient mongoClient;

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient, "tourDeFrance");
    }
}
