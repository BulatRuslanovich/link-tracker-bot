package com.bipbup.service.chat;

import com.bipbup.exceptions.ChatNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeleteTelegramChatService {

    public void validateChatId(long id) {

        if (id == 1) {
            throw new ChatNotFoundException("Chat with ID %d not founded".formatted(id));
        }
    }
}
