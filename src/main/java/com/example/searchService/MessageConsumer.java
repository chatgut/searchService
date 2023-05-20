package com.example.searchService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    private Repository repo;

    public MessageConsumer(Repository repo) {
        this.repo = repo;
    }

    @RabbitListener(queues = "messages")
   public void processMessage(Entity entity) {
        repo.save(entity);
   }
}
