package com.omori.reactiveplayground;

import com.omori.reactiveplayground.controller.EnrichedUserController;
import com.omori.reactiveplayground.entity.User;
import com.omori.reactiveplayground.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class EnrichedUserControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS) // this is cannot check the correction of url/params
    private WebClient webClient;

    @InjectMocks
    private EnrichedUserController enrichedUserController;

    @Test
    void testGetEnrichedUser_Success() {
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setName("John Doe");
        when(userRepository.findById(1L)).thenReturn(Mono.just(mockUser));

        when(webClient.get()
                .uri(anyString(), eq(1L))
                .retrieve()
                .bodyToMono(String.class))
                .thenReturn(Mono.just("{\"name\":\"External User\"}"));

        Mono<ResponseEntity<String>> result = enrichedUserController.getEnrichedUser(1L);

        StepVerifier.create(result)
                .expectNextMatches(response ->
                        response.getStatusCode() == HttpStatus.OK &&
                        response.getBody().contains("John Doe"))
                .verifyComplete();
    }

}
