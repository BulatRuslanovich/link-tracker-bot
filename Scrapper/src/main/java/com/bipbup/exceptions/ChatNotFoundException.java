package com.bipbup.exceptions;

import org.springframework.http.HttpStatus;

public class ChatNotFoundException extends ApiErrorResponseException {

    public static final String DESCRIPTION = "Chat not does not exist";

    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public ChatNotFoundException(String message) {
        super(message, DESCRIPTION, STATUS);
    }
}
