package com.bipbup.bot;

import com.bipbup.menu.CommandsMenu;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GitTrackerBot {

    private final CommandsMenu commandsMenu;

    private final UpdatesListener listener;

    private final TelegramBot telegramBot;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(listener);
        telegramBot.execute(commandsMenu.getCommandsMenu());
    }
}
