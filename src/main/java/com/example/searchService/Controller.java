package com.example.searchService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private Repository repo;

    public Controller(Repository repo) {
        this.repo = repo;
    }

    @PostMapping("/add")
    public void add(@RequestBody Entity entity){
        repo.save(entity);
    }

    @GetMapping("/findAll")
    public Iterable<Entity> findAll(){
        return repo.findAll();
    }

    @GetMapping("/findById/{id}")
    public Entity findById(@PathVariable String id){
        return repo.findById(id).orElseThrow();
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
