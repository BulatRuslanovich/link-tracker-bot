package com.bipbup.config;

import com.bipbup.config.properties.BotProperties;
import com.pengrad.telegrambot.TelegramBot;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class TelegramBotConfig {

    private final BotProperties botProperties;

    @Bean
    public TelegramBot telegramBot() {
        return new TelegramBot(botProperties.getToken());
    }
}
