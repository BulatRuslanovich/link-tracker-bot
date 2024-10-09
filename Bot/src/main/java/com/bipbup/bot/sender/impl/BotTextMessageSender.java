package com.bipbup.bot.sender.impl;

import com.bipbup.bot.sender.Sender;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BotTextMessageSender implements Sender {
    private final TelegramBot telegramBot;

    @Override
    public void send(SendMessage message) {
        telegramBot.execute(message.parseMode(ParseMode.Markdown));
    }
}
