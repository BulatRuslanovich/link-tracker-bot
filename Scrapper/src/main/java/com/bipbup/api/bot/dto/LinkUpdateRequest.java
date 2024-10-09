package com.bipbup.api.bot.dto;

import java.net.URI;
import java.util.List;

public record LinkUpdateRequest(
        long id,
        URI uri,
        String description,
        List<Long> tgChatIds
) {
}
