package com.greetingapp.greetingcontroller.repository;

import com.greetingapp.greetingcontroller.model.GreetingMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface GreetingMessageRepository extends JpaRepository<GreetingMessage, Long> {
        // Custom queries can be added here if needed
    }

