package com.greetingapp.greetingcontroller.servicelayer;

import com.greetingapp.greetingcontroller.model.GreetingMessage;
import com.greetingapp.greetingcontroller.repository.GreetingMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Service
public class GreetingService {

        // Method to return the greeting message
        public String getGreetingMessage() {
            return "Hello World";
        }

        //UC3 ---------------------------------------

    // Method to return greeting message based on user attributes
    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "Hello, " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello, " + firstName + "!";
        } else if (lastName != null) {
            return "Hello, " + lastName + "!";
        } else {
            return "Hello World!";
        }
    }

    //UC4 - save the message in sql database

    private final GreetingMessageRepository greetingMessageRepository;

    @Autowired
    public GreetingService(GreetingMessageRepository greetingMessageRepository) {
        this.greetingMessageRepository = greetingMessageRepository;
    }

    // Method to save a greeting message
    public GreetingMessage saveGreetingMessage(String message) {
        GreetingMessage greetingMessage = new GreetingMessage();
        greetingMessage.setMessage(message);
        return greetingMessageRepository.save(greetingMessage);  // Saves the greeting message in the database
    }

    // UC05: Find a Greeting by ID
    public GreetingMessage getGreetingById(Long id) {
        return greetingMessageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));
    }

    // UC06: Retrieve All Greetings
    public List<GreetingMessage> getAllGreetings() {
        return greetingMessageRepository.findAll();
    }

    // UC07: Update an Existing Greeting
    public GreetingMessage updateGreeting(Long id) {
        // Find existing Greeting by ID
        GreetingMessage existingGreeting = greetingMessageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with ID: " + id));

        // Save the updated Greeting to the database
        return greetingMessageRepository.save(existingGreeting);
}
    }

