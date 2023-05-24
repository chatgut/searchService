package com.example.searchService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/search")
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
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findText/{text}")
    public List<Entity> findByText(@PathVariable String text){
        return repo.findByMessageContaining(text);
    }

}
