package com.cogniva.backend.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/chat")
@Tag(name = "Chat Management", description = "Controller for chat interactions with the AI model")
public class ChatController {
    @PostMapping
    public ResponseEntity<String> chat() {
        return ResponseEntity.ok("Chat endpoint is working");
    }
}
