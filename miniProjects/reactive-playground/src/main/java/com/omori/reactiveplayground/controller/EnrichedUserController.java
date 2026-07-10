package com.omori.reactiveplayground.controller;

import com.omori.reactiveplayground.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class EnrichedUserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebClient webClient;

    @GetMapping("/enriched-user/{id}")
    public Mono<ResponseEntity<String>> getEnrichedUser(@PathVariable Long id) {
        log.info("[START] /enriched-user/{}", id);
        return userRepository.findById(id)
                .doOnNext(user -> log.info("Found user in DB: {}", user.getName()))
                .flatMap(user -> webClient.get()
                        .uri("/users/{id}", user.getId())
                        .retrieve()
                        .bodyToMono(String.class)
                        .map(externalUserJson -> "User " + user.getName() + " | External Data: " + externalUserJson))
                .map(ResponseEntity::ok) // Status 200
                .doOnNext(response -> log.info("Return response succeed, status: {}", response.getStatusCode()))
                .switchIfEmpty(Mono.defer(() -> { // Only calculate value when Mono have been subscribe
                            log.warn("Can not find user with id: {}", id);
                            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
                                    .body("Can't found user with ID: " + id));
                        }
                ))
//                .switchIfEmpty(
//                        Mono.just(buildNotFoundResponse(id))) // -> Running immediately, even switchIfEmpty have trigger or not, maybe cause side effect
                ;
    }


    private ResponseEntity<String> buildNotFoundResponse(Long id) {
        log.info(">>> LOGGING [Mono.just error testing] for id = {}", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Can't found user with id: " + id);
    }
}


