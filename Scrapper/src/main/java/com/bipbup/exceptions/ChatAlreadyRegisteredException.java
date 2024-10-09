package com.bipbup.exceptions;

public class ChatAlreadyRegisteredException extends RuntimeException {
    public static final String DESCRIPTION = "Chat is already registered";

    public ChatAlreadyRegisteredException(String message) {
        super(message);
    }
}
