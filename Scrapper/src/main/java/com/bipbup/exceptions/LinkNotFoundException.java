package com.bipbup.exceptions;

import org.springframework.http.HttpStatus;

public class LinkNotFoundException extends ApiErrorResponseException {

    public static final String DESCRIPTION = "Link not found";

    private static final HttpStatus STATUS = HttpStatus.NOT_FOUND;

    public LinkNotFoundException(String message) {
        super(message, DESCRIPTION, STATUS);
    }
}
