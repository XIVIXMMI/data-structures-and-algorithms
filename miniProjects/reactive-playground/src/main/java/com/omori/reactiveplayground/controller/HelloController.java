package com.omori.reactiveplayground.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello World")
                .doOnNext(msg -> System.out.println("Thread processing: " + Thread.currentThread().getName()));
    }

    @GetMapping(value = "stream", produces = "text/value-stream")
    public Flux<String> stream() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> "Event " + i + " at " + System.currentTimeMillis() + " \n")
                .doOnNext(msg -> System.out.println("Thread processing: " + Thread.currentThread().getName()));
    }

    @GetMapping("/get-blocking")
    public Mono<String> blockingTest() throws InterruptedException {
        System.out.println("BLOCKING THREAD: " + Thread.currentThread().getName());
        Thread.sleep(3000); // blocking
        return Mono.just("Done (blocking)");
    }

    @GetMapping("/non-blocking")
    public Mono<String> nonblockingTest() {
        return Mono.delay(Duration.ofSeconds(3)).map(i -> {
            System.out.println("NON-BLOCKING THREAD: " + Thread.currentThread().getName());
            return "Done (non-blocking)";
        });
    }
}
