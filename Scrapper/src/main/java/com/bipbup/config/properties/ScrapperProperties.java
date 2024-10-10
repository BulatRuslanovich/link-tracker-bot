package com.bipbup.config.properties;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@Validated
@ConfigurationProperties(value = "scrapper", ignoreUnknownFields = false)
public record ScrapperProperties(
    Scheduler scheduler
) {
    public record Scheduler(
            boolean enable,
            @NotNull Duration interval,
            @NotNull Duration forceCheckDelay
    ) {
    }
}
