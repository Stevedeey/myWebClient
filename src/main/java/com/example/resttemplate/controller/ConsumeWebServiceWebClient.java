package com.example.resttemplate.controller;

import com.example.resttemplate.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ConsumeWebServiceWebClient {

    @Autowired
    WebClient webClient;
    //ADD A POST AND DELETE
    //FLUX OR MONO
    @GetMapping(value = "/webclient/questions")
    public Flux<Question> findAll()
    {
        return webClient.get()
                .uri("/questions")
                .retrieve()
                .bodyToFlux(Question.class);
    }

    @PostMapping("/webclient/questions")
    public Mono<Question> createQuestion(Question question){
        return webClient.post()
                .uri("/questions")
                .body(Mono.just(question), Question.class)
                .retrieve()
                .bodyToMono(Question.class);
    }

    @DeleteMapping("/webclient/questions/{id}")
    public Mono<Question> deleteQuestion(@PathVariable("id") Integer id) {
        return webClient.delete()
                .uri("/questions/" + id)
                .retrieve()
                .bodyToMono(Question.class);
    }


}
