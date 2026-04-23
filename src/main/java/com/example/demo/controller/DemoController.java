package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.DemoService;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class DemoController {
    private final DemoService service;


    public DemoController(DemoService service) {
        this.service = service;
    }

    @RequestMapping("/welcome")
    String welcome() {
        return "Welcome to our system.";
    }

    @GetMapping
    public List<User> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
