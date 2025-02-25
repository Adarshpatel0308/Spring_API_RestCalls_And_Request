package com.greetingapp.greetingcontroller.controller;

import com.greetingapp.greetingcontroller.model.GreetingMessage;
import com.greetingapp.greetingcontroller.servicelayer.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //UC2

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

    //UC3 - Give lastName and firstName

    // GET request - Accepts firstName and lastName as query parameters
    @GetMapping("/UC3")
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        String greetingMessage = greetingService.getGreetingMessage(firstName, lastName);
        return "{\"message\": \"" + greetingMessage + "\"}";
    }

    //UC4 --> API to save the message to the database

    // Endpoint to save a greeting message
    @PostMapping("/UC4")
    public String saveGreeting(@RequestBody Map<String, String> request) {
        String message = request.get("message");
        greetingService.saveGreetingMessage(message);
        return "Greeting message saved!";
    }

    // UC5: Find Greeting by ID
    @GetMapping("/{id}")
    public GreetingMessage getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
}

