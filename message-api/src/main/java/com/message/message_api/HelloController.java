package com.message.message_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private MongoService mongoService;

    @GetMapping("/testConnection")
    public String testConnection() {
        try {
            mongoService.addDocument("Hello from MongoDB!");
            return "MongoDB connection successful! Document added.";
        } catch (Exception e) {
            return "MongoDB connection failed: " + e.getMessage();
        }
    }
}
