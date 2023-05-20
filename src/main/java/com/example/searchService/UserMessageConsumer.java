package com.example.searchService;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class UserMessageConsumer {

        private Repository repo;

        public UserMessageConsumer(Repository repo) {
            this.repo = repo;
        }

        @RabbitListener(queues = "users")
        public void processMessage(Entity entity) {
            repo.save(entity);
        }

}
