package com.example.note_api.controller;

import com.example.note_api.dto.SampleMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/sample")
    public String sample() {
        return "Hello, Spring Boot API!";
    }

    @GetMapping("/sample/api")
    public ResponseEntity<SampleMessage> sampleApi() {
        SampleMessage message = new SampleMessage();
        message.setId(100);
        message.setMessage("Hello, JSON Response!");
        return ResponseEntity.ok(message);
    }
}
