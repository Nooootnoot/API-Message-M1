package com.message.message_api.model;

import lombok.Data;

@Data
public class MessageUpdateRequest {

    private String texte;
    private Boolean lu;
    private String sujet;
}
