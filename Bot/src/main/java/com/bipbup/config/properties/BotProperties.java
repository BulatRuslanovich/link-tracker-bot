package com.bipbup.config.properties;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationProperties(value = "bot", ignoreUnknownFields = false)
public class BotProperties {
    @NotEmpty
    String token;
}
