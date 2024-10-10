package com.bipbup.config.properties;

import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties(value = "clients", ignoreUnknownFields = false)
public record ClientsProperties(
        @Validated
        Scrapper scrapper
) {
    public record Scrapper(
            @NotEmpty
            @URL
        String baseUri
    ) {}
}
