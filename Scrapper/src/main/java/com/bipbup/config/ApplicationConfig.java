package com.bipbup.config;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@Validated
@ConfigurationProperties(prefix = "scrapper", ignoreUnknownFields = false)
public record ApplicationConfig(
        @NotNull
        Scheduler scheduler
) {
        public record Scheduler(boolean enable, @NotNull Duration interval, @NotNull Duration forceCheckDelay) {
        }
}
