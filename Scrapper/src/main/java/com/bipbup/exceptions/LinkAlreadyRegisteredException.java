package com.bipbup.exceptions;

public class LinkAlreadyRegisteredException extends RuntimeException {
    public static final String DESCRIPTION = "Link is already registered";

    public LinkAlreadyRegisteredException(String message) {
        super(message);
    }
}
