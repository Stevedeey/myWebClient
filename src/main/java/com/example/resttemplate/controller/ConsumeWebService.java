package com.example.resttemplate.controller;

import com.example.resttemplate.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class ConsumeWebService {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/template/questions")
    public String getQuestions() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("http://localhost:7070/questions", HttpMethod.GET, entity, String.class).getBody();
    }
    @RequestMapping(value = "/template/questions", method = RequestMethod.POST)
    public String createQuestions(@RequestBody Question question) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Question> entity = new HttpEntity<Question>(question,headers);

        return restTemplate.exchange(
                "http://localhost:7070/questions", HttpMethod.POST, entity, String.class).getBody();
    }
    @RequestMapping(value = "/template/questions/{id}", method = RequestMethod.PUT)
    public String updateQuestions(@PathVariable("id") String id, @RequestBody Question question) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Question> entity = new HttpEntity<Question>(question,headers);

        return restTemplate.exchange(
                "http://localhost:7070/questions/"+id, HttpMethod.PUT, entity, String.class).getBody();
    }
    @RequestMapping(value = "/template/questions/{id}", method = RequestMethod.DELETE)
    public String deleteQuestions(@PathVariable("id") String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Question> entity = new HttpEntity<Question>(headers);

        return restTemplate.exchange(
                "http://localhost:7070/questions/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
