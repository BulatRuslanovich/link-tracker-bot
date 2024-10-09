package com.bipbup.util;

import com.bipbup.command.Command;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;


public final class CommandUtils {
    private CommandUtils() {
    }

    public static SendMessage handleMessage(
            Update update,
            Command command,
            String successMessage,
            String incorrectCommandMessage,
            String incorrectFormatMessage
    ) {
        var chatId = command.getChatId(update);
        var pair = update.message().text().split(" ");

        if (pair.length == 2) {
            if (pair[0].equals(command.command())) {
                return new SendMessage(chatId, successMessage);
            }

            return new SendMessage(chatId, incorrectCommandMessage);
        }

        return new SendMessage(chatId, incorrectFormatMessage);
    }
}
