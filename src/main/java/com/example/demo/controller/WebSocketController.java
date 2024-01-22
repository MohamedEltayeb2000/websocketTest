package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/sendToESP")
    @SendTo("/topic/messages")
    public String sendToESP(String message) {
        // Process the message and send a response
        return "Response from server: " + message;
    }
}
