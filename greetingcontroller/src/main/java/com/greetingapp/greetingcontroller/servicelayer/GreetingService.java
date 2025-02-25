package com.greetingapp.greetingcontroller.servicelayer;

import com.greetingapp.greetingcontroller.model.GreetingMessage;
import com.greetingapp.greetingcontroller.repository.GreetingMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    }

