package com.message.message_api.controller;

import com.message.message_api.model.Message;
import com.message.message_api.model.MessageCreationRequest;
import com.message.message_api.model.MessageUpdateRequest;
import com.message.message_api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<Message> createMessage(@Valid @RequestBody MessageCreationRequest request) {
        Message message = messageService.createMessage(request);
        System.out.println("coucou");
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable String id) {
        Optional<Message> message = messageService.getMessageById(id);
        return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/etudiants/{id}")
    public ResponseEntity<List<Message>> getMessagesByEtudiantId(@PathVariable Long id, @RequestParam(required = false) Boolean lu) {
        List<Message> messages = messageService.getMessagesByEtudiantId(id);
        if (lu != null) {
            messages = messages.stream().filter(m -> m.getLu().equals(lu)).toList();
        }
        return ResponseEntity.ok(messages);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable String id, @Valid @RequestBody MessageUpdateRequest request) {
        Message updatedMessage = messageService.updateMessage(id, request);
        return updatedMessage != null ? ResponseEntity.ok(updatedMessage) : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable String id) {
        boolean isDeleted = messageService.deleteMessage(id);
        return isDeleted ? ResponseEntity.noContent().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
