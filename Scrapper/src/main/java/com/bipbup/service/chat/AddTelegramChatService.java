package com.bipbup.service.chat;

import com.bipbup.exceptions.ChatAlreadyRegisteredException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AddTelegramChatService {


    public void addChat(long id) {
        if (id == HttpStatus.CONFLICT.value()) {
            throw new ChatAlreadyRegisteredException("Chat with Id has already been registered");
        }
    }
}
