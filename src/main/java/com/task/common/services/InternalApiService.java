package com.task.common.services;
import com.task.Task.TaskDto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;



@Service
@RequiredArgsConstructor
public class InternalApiService {
    private final WebClient webClient = WebClient.builder().baseUrl("http://localhost:8081/internal/user").build();  // builder design pattern instead of Webclient webclient = new Webclient();
   @Transactional(isolation = Isolation.SERIALIZABLE)
    public UserResponse getUser(Long id){
        UserResponse userResponse = webClient
                .get()
                .uri(uriBuilder -> uriBuilder.path("/{id}").build(id))
                .retrieve()
                .onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals, clientResponse -> Mono.error(RuntimeException::new))
                .bodyToMono(UserResponse.class)
                .block();
        return userResponse;
    }


}
