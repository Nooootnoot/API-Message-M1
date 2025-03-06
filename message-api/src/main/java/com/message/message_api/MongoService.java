package com.message.message_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class MongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void addDocument(String message) {
        TestDocument testDocument = new TestDocument(message);
        mongoTemplate.save(testDocument);
    }
}
