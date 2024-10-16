package com.bipbup.command.impl;

import com.bipbup.command.Command;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.bipbup.util.ResponseMessages.DEFAULT_INCORRECT_COMMAND;
import static com.bipbup.util.ResponseMessages.DUMMY_LINKS;
import static com.bipbup.util.ResponseMessages.LIST_COMMAND;
import static com.bipbup.util.ResponseMessages.LIST_DESCRIPTION;
import static com.bipbup.util.ResponseMessages.LIST_TITLE;

@Component
public class ListCommand implements Command {

    @Override
    public String command() {
        return LIST_COMMAND;
    }

    @Override
    public String description() {
        return LIST_DESCRIPTION;
    }

    @Override
    public SendMessage handle(Update update) {
        var chatId = getChatId(update);

        if (!update.message().text().equals(command())) {
            return new SendMessage(chatId, DEFAULT_INCORRECT_COMMAND);
        }

        String sendMessage = buildListOfLinks(DUMMY_LINKS);
        return new SendMessage(chatId, sendMessage).disableWebPagePreview(true);
    }

    private String buildListOfLinks(List<String> links) {
        return LIST_TITLE
                + IntStream.range(1, links.size() + 1)
                .mapToObj(i -> "*" + i + "*: " + links.get(i - 1))
                .collect(Collectors.joining("\n"));
    }
}
