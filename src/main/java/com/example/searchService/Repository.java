package com.example.searchService;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface Repository extends ElasticsearchRepository<Entity, String> {

    Entity findById(String id);

    List<Entity> findByUserName(String name);

    List<Entity> findByChatTextContaining(String text);

    List<Entity> findAll();
}
