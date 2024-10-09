package com.bipbup.exceptions;

public class ChatNotFoundException extends RuntimeException {

    public static final String DESCRIPTION = "Chat not does not exist";

    public ChatNotFoundException(String message) {
        super(message);
    }
}
