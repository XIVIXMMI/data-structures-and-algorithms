package com.omori.reactiveplayground.repository;

import com.omori.reactiveplayground.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCrudRepository<User,Long> {
    Flux<User> findByName(String name);
}
