package com.bipbup.exceptions;

import org.springframework.http.HttpStatus;

public class LinkAlreadyRegisteredException extends ApiErrorResponseException {

    public static final String DESCRIPTION = "Link is already registered";

    private static final HttpStatus STATUS = HttpStatus.CONFLICT;

    public LinkAlreadyRegisteredException(String message) {
        super(message, DESCRIPTION, STATUS);
    }
}
