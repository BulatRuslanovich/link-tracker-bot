package com.bipbup.config;

import com.bipbup.api.bot.BotClient;
import com.bipbup.config.properties.ClientsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ScrapperConfig {

    private final ClientsProperties clientsProperties;

    @Bean
    public BotClient botClient() {
        return new BotClient(clientsProperties.bot().baseUri());
    }
}
