package com.omori.reactiveplayground.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.*;
import java.time.Duration;

@RestController
public class ExternalApiController {

    private final WebClient webClient;

    public ExternalApiController(WebClient webClient) {
        this.webClient = webClient;
    }

    @GetMapping("/external-user/{id}")
    public Mono<String> getExternalUser(@PathVariable String id) {
        System.out.println("Thread before call: " + Thread.currentThread().getName());
        return webClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(String.class)
                .doOnNext(
                        response -> System.out.println("Thread when get response: "
                                + Thread.currentThread().getName()));
    }

    @GetMapping("/combined-user/{id}")
    public Mono<String> getCombinedData(@PathVariable String id) {

        Mono<String> usersMono = webClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(String.class);

        Mono<String> postsMono = webClient.get()
                .uri("/posts?userId={id}", id)
                .retrieve()
                .bodyToMono(String.class);

        Mono<String> todosMono = webClient.get()
                .uri("/todos?userId={id}", id)
                .retrieve()
                .bodyToMono(String.class);

        return Mono.zip(usersMono, postsMono, todosMono)
                .map(tuple ->
                        "User: " + tuple.getT1().length() + " chars, "
                                + "Post: " + tuple.getT2().length() + " chars, "
                                + "Todo: " + tuple.getT3().length() + " chars"
                );
    }

    @GetMapping("/user-with-delay/{id}")
    public Mono<String> getUserWithDelay(@PathVariable String id) {

        Mono<String> delay1 = webClient.get()
                .uri("/posts?userId={id}", id)
                .retrieve()
                .bodyToMono(String.class)
                .delayElement(Duration.ofSeconds(3));

        Mono<String> delay2 = webClient.get()
                .uri("/todos?userId={id}", id)
                .retrieve()
                .bodyToMono(String.class)
                .delayElement(Duration.ofSeconds(5));

        return Mono.zip(delay1, delay2)
                .map(tuple ->
                        "DELAY 1: " + tuple.getT1().length() + " chars " + "\n"
                                + "DELAY 2: " + tuple.getT2().length() + " chars "
                );
    }

    @GetMapping("/user-posts/{id}")
    public Flux<String> getUserPosts(@PathVariable String id){

        return webClient.get()
                .uri("/posts?userId={id}", id)
                .retrieve()
                .bodyToFlux(String.class)
                .doOnNext(post ->
                        System.out.println("Get the posts - Thread: " + Thread.currentThread().getName()));
    }

    @GetMapping(value = "/posts-stream/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getPostsStream(@PathVariable String id){

        return webClient.get()
                .uri("/posts?userId={id}", id)
                .retrieve()
                .bodyToFlux(String.class)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(post ->
                        System.out.println("Get the posts - Thread: " + Thread.currentThread().getName()));
    }

}
