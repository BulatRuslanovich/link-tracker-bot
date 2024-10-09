package com.bipbup.config;

import com.pengrad.telegrambot.TelegramBot;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class TelegramBotConfig {

    @Bean
    public TelegramBot telegramBot(@Value("${bot.token}") String token) {
        return new TelegramBot(token);
    }
}
