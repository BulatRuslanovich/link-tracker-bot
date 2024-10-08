package com.bipbup.bot;

import com.bipbup.processor.Processor;
import com.bipbup.sender.Sender;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class BotUpdateListener implements UpdatesListener {
    private final Processor processor;
    private final Sender sender;

    @Override
    public int process(List<Update> updates) {
        updates.stream()
                .filter(u -> u.editedMessage() == null)
                .forEach(u -> sender.send(processor.process(u)));

        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }
}
