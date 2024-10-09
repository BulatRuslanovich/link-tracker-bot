package com.bipbup.bot;

import com.bipbup.command.Command;
import com.bipbup.bot.processor.BotMessageProcessor;
import com.bipbup.bot.processor.impl.BotTextMessageProcessor;
import com.bipbup.bot.sender.Sender;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class BotUpdateListener implements UpdatesListener {
    private final BotMessageProcessor botMessageProcessor;
    private final Sender sender;

    public BotUpdateListener(List<Command> commands, Sender sender) {
        this.botMessageProcessor = new BotTextMessageProcessor(commands);
        this.sender = sender;
    }

    @Override
    public int process(List<Update> updates) {
        updates.stream()
                .filter(u -> u.editedMessage() == null)
                .forEach(u -> sender.send(botMessageProcessor.process(u)));

        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
