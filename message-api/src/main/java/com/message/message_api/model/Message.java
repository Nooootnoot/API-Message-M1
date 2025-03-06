package com.message.message_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "messages")
public class Message {

    @Id
    private String id;
    private String texte;
    private Boolean lu;
    private String sujet;
    private Long etudiantId;
    private LocalDateTime dateCreation;
}
