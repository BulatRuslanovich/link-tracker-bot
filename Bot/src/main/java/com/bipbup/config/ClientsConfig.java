package com.bipbup.config;

import com.bipbup.api.ScrapperClient;
import com.bipbup.config.properties.ClientsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class ClientsConfig {

    private final ClientsProperties clientsProperties;

    @Bean
    public ScrapperClient scrapperClient() {
        return new ScrapperClient(clientsProperties.scrapper().baseUri());
    }
}
