package com.message.message_api.service;

import com.message.message_api.model.Message;
import com.message.message_api.model.MessageCreationRequest;
import com.message.message_api.model.MessageUpdateRequest;
import com.message.message_api.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message createMessage(MessageCreationRequest request) {
        Message message = new Message();
        message.setTexte(request.getTexte());
        message.setSujet(request.getSujet());
        message.setEtudiantId(request.getEtudiantId());
        message.setLu(false);
        message.setDateCreation(java.time.LocalDateTime.now());
        return messageRepository.save(message);
    }

    public Optional<Message> getMessageById(String id) {
        return messageRepository.findById(id);
    }

    public List<Message> getMessagesByEtudiantId(Long etudiantId) {
        return messageRepository.findByEtudiantId(etudiantId);
    }

    public Message updateMessage(String id, MessageUpdateRequest request) {
        Optional<Message> existingMessage = messageRepository.findById(id);
        if (existingMessage.isPresent()) {
            Message message = existingMessage.get();
            if (request.getTexte() != null) message.setTexte(request.getTexte());
            if (request.getLu() != null) message.setLu(request.getLu());
            if (request.getSujet() != null) message.setSujet(request.getSujet());
            return messageRepository.save(message);
        }
        return null;
    }

    public boolean deleteMessage(String id) {
        Optional<Message> message = messageRepository.findById(id);
        if (message.isPresent()) {
            messageRepository.delete(message.get());
            return true;
        }
        return false;
    }
}
