package com.bipbup.bot.processor;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

public interface BotMessageProcessor {
    SendMessage process(Update update);
}
