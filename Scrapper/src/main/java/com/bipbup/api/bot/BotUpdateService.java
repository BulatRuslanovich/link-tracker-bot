package com.bipbup.api.bot;

import com.bipbup.api.bot.dto.LinkUpdateRequest;
import org.springframework.web.bind.annotation.RequestBody;

public interface BotUpdateService {
    void updateBot(@RequestBody LinkUpdateRequest linkUpdateRequest);
}
