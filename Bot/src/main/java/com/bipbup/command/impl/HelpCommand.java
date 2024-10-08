package com.bipbup.command.impl;

import com.bipbup.command.Command;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.bipbup.util.ResponseMessages.DEFAULT_INCORRECT_COMMAND;
import static com.bipbup.util.ResponseMessages.HELP_COMMAND;
import static com.bipbup.util.ResponseMessages.HELP_DESCRIPTION;

@Component
@RequiredArgsConstructor
public class HelpCommand implements Command {

    private final List<Command> commands;

    @Override
    public String command() {
        return HELP_COMMAND;
    }

    @Override
    public String description() {
        return HELP_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        var chatId = getChatId(update);

        if (update.message().text().equals(command())) {
            var builder = new StringBuilder();

            builder.append(command())
                    .append(" - ")
                    .append(description())
                    .append("\n");

            commands.forEach(c -> builder
                    .append(c.command())
                    .append(" - ")
                    .append(c.description())
                    .append("\n"));

            return new SendMessage(chatId, builder.toString());
        }

        return new SendMessage(chatId, DEFAULT_INCORRECT_COMMAND);
    }
}
