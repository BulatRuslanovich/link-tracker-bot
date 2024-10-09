package com.bipbup.service.chat;

import com.bipbup.exceptions.ChatNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DeleteTelegramChatService {

    public void deleteChat(long id) {
        if (id == HttpStatus.NOT_FOUND.value()) {
            throw new ChatNotFoundException("Chat with ID %d not founded".formatted(id));
        }
    }
}
