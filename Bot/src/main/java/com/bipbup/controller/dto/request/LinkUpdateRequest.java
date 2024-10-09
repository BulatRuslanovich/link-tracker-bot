package com.bipbup.controller.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.net.URL;
import java.util.List;

public record LinkUpdateRequest(
        @Min(value = 0, message = "ID should be more or equal 0")
        long id,
        @NotNull(message = "URL should not be null")
        URL url,
        String description,
        List<Long> tgChatIds
) {
}
