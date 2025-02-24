package com.greetingapp.greetingcontroller.servicelayer;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

        // Method to return the greeting message
        public String getGreetingMessage() {
            return "Hello World";
        }
    }

