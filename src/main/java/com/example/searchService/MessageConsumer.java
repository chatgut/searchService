package com.example.searchService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Component
public class MessageConsumer {

    private Repository repo;
    private ObjectMapper objectMapper;

    public MessageConsumer(Repository repo, ObjectMapper objectMapper) {
        this.repo = repo;
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = "messages")
    public void consumeMessage(String jsonMessage) {
        try {
            Entity entity = objectMapper.readValue(jsonMessage, Entity.class);
            repo.save(entity);
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
