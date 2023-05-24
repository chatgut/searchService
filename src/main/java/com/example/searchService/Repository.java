package com.example.searchService;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface Repository extends ElasticsearchRepository<Entity, String> {

    List<Entity> findByMessageContaining(String text);

}
