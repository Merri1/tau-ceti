package com.fyp.tauceti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Spring Boot application main class
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class TauCetiApplication {
    /**
     * Starts the Spring ApplicationContext
     * @see org.springframework.context.ApplicationContext
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(TauCetiApplication.class, args);
    }
}


