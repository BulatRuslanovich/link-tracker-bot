package com.bipbup.bot.sender;

import com.pengrad.telegrambot.request.SendMessage;

public interface Sender {
    void send(SendMessage message);
}
