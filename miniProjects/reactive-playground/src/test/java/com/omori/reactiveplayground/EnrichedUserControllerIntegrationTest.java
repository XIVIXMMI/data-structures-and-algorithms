package com.omori.reactiveplayground;

import com.omori.reactiveplayground.controller.EnrichedUserController;
import com.omori.reactiveplayground.entity.User;
import com.omori.reactiveplayground.repository.UserRepository;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EnrichedUserControllerIntegrationTest {
    private MockWebServer mockWebServer;
    private WebClient webClient;

    @BeforeEach
    void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();

        webClient = WebClient.builder()
                .baseUrl(mockWebServer.url("/").toString())
                .build();
    }

    @AfterEach
    void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void testGetEnrichedUser_Success() {
        mockWebServer.enqueue(new MockResponse()
                .setBody("{\"name\":\"External User\"}")
                .addHeader("Content-Type", "application/json"));

        UserRepository mockRepo = mock(UserRepository.class);
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("John Doe");
        when(mockRepo.findById(1L)).thenReturn(Mono.just(mockUser));

        EnrichedUserController controller = new EnrichedUserController(mockRepo, webClient);

        StepVerifier.create(controller.getEnrichedUser(1L))
                .expectNextMatches(response -> response.getStatusCode() == HttpStatus.OK)
                .verifyComplete();
    }

}
