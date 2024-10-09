package com.bipbup.command.impl;

import com.bipbup.command.Command;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

import static com.bipbup.util.ResponseMessages.DEFAULT_INCORRECT_COMMAND;
import static com.bipbup.util.ResponseMessages.START_COMMAND;
import static com.bipbup.util.ResponseMessages.START_DESCRIPTION;
import static com.bipbup.util.ResponseMessages.WELCOME_MESSAGE;
import static com.bipbup.util.ResponseMessages.WELCOME_TITLE;

@Component
public class StartCommand implements Command {

    @Override
    public String command() {
        return START_COMMAND;
    }

    @Override
    public String description() {
        return START_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        var chatId = getChatId(update);

        if (update.message().text().equals(command())) {
            String sendMessage = String.format(WELCOME_TITLE, update.message().from().firstName())
                    + WELCOME_MESSAGE;
            return new SendMessage(chatId, sendMessage);
        }

        return new SendMessage(chatId, DEFAULT_INCORRECT_COMMAND);
    }
}
