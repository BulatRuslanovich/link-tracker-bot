package com.bipbup.exceptions;

public class LinkNotFoundException extends RuntimeException {

    public static final String DESCRIPTION = "Link not found";

    public LinkNotFoundException(String message) {
        super(message);
    }
}
