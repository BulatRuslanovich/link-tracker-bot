package com.bipbup.controller;

import com.bipbup.service.chat.DeleteTelegramChatService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tg-chat")
public class TelegramChatsController {
    private final DeleteTelegramChatService deleteTelegramChatService;

    @PostMapping("{id}")
    public void postTgChat(
            @Min(value = 0, message = "ID should be more or equal 0")
            @PathVariable
            long id
    ) { /* TODO document why this method is empty */ }

    @DeleteMapping("{id}")
    public void deleteTgChat(
            @Min(value = 0, message = "ID should be more or equal 0")
            @PathVariable
            long id
    ) {
        deleteTelegramChatService.validateChatId(id);
    }
}
