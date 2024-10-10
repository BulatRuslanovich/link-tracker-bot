package com.bipbup.config.properties;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(value = "clients", ignoreUnknownFields = false)
public record ClientsProperties(
        @Validated
        Bot bot
) {
    public record Bot(
            @NotEmpty
            @URL
        String baseUri
    ) {}
}
