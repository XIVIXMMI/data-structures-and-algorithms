package com.omori.reactiveplayground.controller;

import com.omori.reactiveplayground.entity.User;
import com.omori.reactiveplayground.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/db-users")
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/db-users/{id}")
    public Mono<User> getUserById(@PathVariable Long id) {
        return userRepository.findById(id);
    }

}
