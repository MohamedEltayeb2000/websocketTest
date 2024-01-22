package com.example.demo.controller;

// WebSocketController.java
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/connect")
    @SendTo("/topic/messages")
    public String handleWebSocketConnect(String message) {
        // Handle the incoming message (e.g., log or process)
        System.out.println("Received message: " + message);
        return "Server received your message: " + message;
    }
}
