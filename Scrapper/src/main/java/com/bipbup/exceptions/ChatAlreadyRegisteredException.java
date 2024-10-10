package com.bipbup.exceptions;

import org.springframework.http.HttpStatus;

public class ChatAlreadyRegisteredException extends ApiErrorResponseException {
    private static final String DESCRIPTION = "Chat is already registered";

    private static final HttpStatus STATUS = HttpStatus.CONFLICT;

    public ChatAlreadyRegisteredException(String message) {
        super(message, DESCRIPTION, STATUS);
    }
}
