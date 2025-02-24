package com.greetingapp.greetingcontroller.controller;

import com.greetingapp.greetingcontroller.servicelayer.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

        //UC1

        @GetMapping
        public Map<String, String> getGreeting() {
            return Map.of("message", "Hello from GET method!");
        }

        @PostMapping
        public Map<String, String> postGreeting(@RequestBody Map<String, String> request) {
            return Map.of("message", "Hello from POST method!", "received", request.get("name"));
        }

        @PutMapping
        public Map<String, String> putGreeting(@RequestBody Map<String, String> request) {
            return Map.of("message", "Hello from PUT method!", "updated", request.get("name"));
        }

        @DeleteMapping
        public Map<String, String> deleteGreeting() {
            return Map.of("message", "Hello from DELETE method!");
        }

        //UC2-Add Service Layer

    private final GreetingService greetingService;

    // Constructor injection of the GreetingService
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/UC2")
    public String greetingService() {
        // Use GreetingService to get the greeting message
        String greetingMessage = greetingService.getGreetingMessage();
        return "{\"message\": \"" + greetingMessage + "\"}";
    }

    }
