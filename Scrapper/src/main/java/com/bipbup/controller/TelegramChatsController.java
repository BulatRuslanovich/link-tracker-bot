package com.bipbup.controller;

import com.bipbup.service.chat.AddTelegramChatService;
import com.bipbup.service.chat.DeleteTelegramChatService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
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

    private final AddTelegramChatService addTelegramChatService;


    @PostMapping("{id}")
    public void postTgChat(
            @Validated
            @Min(value = 0, message = "{error.id_is_null:null}")
            @PathVariable("id")
            long id
    ) {
        addTelegramChatService.addChat(id);
    }

    @DeleteMapping("{id}")
    public void deleteTgChat(
            @Validated
            @Min(value = 0, message = "ID should be more or equal 0")
            @PathVariable("id")
            long id
    ) {
        deleteTelegramChatService.deleteChat(id);
    }
}
