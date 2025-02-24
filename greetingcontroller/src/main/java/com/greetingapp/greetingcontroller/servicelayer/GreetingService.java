package com.greetingapp.greetingcontroller.servicelayer;

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
    }

