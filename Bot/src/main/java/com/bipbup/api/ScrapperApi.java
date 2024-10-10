package com.bipbup.api;

import com.bipbup.api.dto.request.AddLinkRequest;
import com.bipbup.api.dto.request.RemoveLinkRequest;
import com.bipbup.api.dto.response.LinkResponse;
import com.bipbup.api.dto.response.ListLinksResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

public interface ScrapperApi {
    @PostExchange("tg-chat/{id}")
    void postTgChat(@PathVariable("id") long id);

    @DeleteExchange("tg-chat/{id}")
    void deleteTgChat(@PathVariable("id") long id);

    @GetExchange("links")
    ListLinksResponse getLinks(@RequestHeader("Tg-Chat-Id") long tgChatId);

    @PostExchange("links")
    LinkResponse postLink(
            @RequestHeader("Tg-Chat-Id") long tgChatId,
            @RequestBody AddLinkRequest addLinkRequest
    );

    @DeleteExchange("links")
    LinkResponse deleteLink(
            @RequestHeader("Tg-Chat-Id") long tgChatId,
            @RequestBody RemoveLinkRequest removeLinkRequest
    );
}
