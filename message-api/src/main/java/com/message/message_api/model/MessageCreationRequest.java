package com.message.message_api.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MessageCreationRequest {

    @NotNull
    private String texte;

    @NotNull
    private String sujet;

    @NotNull
    private Long etudiantId;
}
