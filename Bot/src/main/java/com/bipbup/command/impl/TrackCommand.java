package com.bipbup.command.impl;

import com.bipbup.command.Command;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

import static com.bipbup.util.ResponseMessages.TRACK_COMMAND;
import static com.bipbup.util.ResponseMessages.TRACK_DESCRIPTION;
import static com.bipbup.util.ResponseMessages.TRACK_INCORRECT_COMMAND;
import static com.bipbup.util.ResponseMessages.TRACK_INCORRECT_FORMAT;
import static com.bipbup.util.ResponseMessages.TRACK_SUCCESS;

@Component
public class TrackCommand implements Command {

    @Override
    public String command() {
        return TRACK_COMMAND;
    }

    @Override
    public String description() {
        return TRACK_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        var chatId = getChatId(update);
        var pair = update.message().text().split(" ");

        if (pair.length == 2) {
            if (pair[0].equals(command())) {
                return new SendMessage(chatId, TRACK_SUCCESS);
            }

            return new SendMessage(chatId, TRACK_INCORRECT_COMMAND);
        }

        return new SendMessage(chatId, TRACK_INCORRECT_FORMAT);
    }
}
