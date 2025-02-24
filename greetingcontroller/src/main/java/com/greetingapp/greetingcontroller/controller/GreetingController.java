package com.greetingapp.greetingcontroller.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

        //UC01

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
    }
