package com.bipbup.processor.impl;

import com.bipbup.command.Command;
import com.bipbup.processor.Processor;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.bipbup.util.ResponseMessages.UNSUPPORTED_COMMAND;

@RequiredArgsConstructor
@Component
public class MessageProcessor implements Processor {
    private final List<Command> commands;

    @Override
    public SendMessage process(Update update) {
        var chatId = update.message().chat().id();
        var notSupportedMessage = new SendMessage(chatId, UNSUPPORTED_COMMAND);

        if (update.message().text() != null) {
            return notSupportedMessage;
        }

        return commands.stream()
                .filter(c -> c.supports(update))
                .map(command -> command.handle(update))
                .findFirst()
                .orElse(notSupportedMessage);
    }

}
