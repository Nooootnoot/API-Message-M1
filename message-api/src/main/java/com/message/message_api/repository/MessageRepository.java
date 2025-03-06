package com.message.message_api.repository;

import com.message.message_api.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MessageRepository extends MongoRepository<Message, String> {
    List<Message> findByEtudiantId(Long etudiantId);
    Optional<Message> findById(String id);
}
