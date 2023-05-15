package com.example.searchService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private Repository repo;

    @GetMapping("/findAll")
    public Iterable<Entity> findAll(){
        return repo.findAll();
    }

    @GetMapping("/findById/{id}")
    public Entity findById(@PathVariable String id){
        return repo.findById(id);
    }

    @GetMapping("/findByName/{name}")
    public List<Entity> findByName(@PathVariable String name){
        return repo.findByUserName(name);
    }

    @GetMapping("/findText/{text}")
    public List<Entity> findByText(@PathVariable String text){
        return repo.findByChatTextContaining(text);
    }

}
