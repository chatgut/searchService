package com.example.searchService;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends ElasticsearchRepository<Entity, String> {

    List<Entity> findByUserName(String name);

    List<Entity> findByChatTextContaining(String text);

}
