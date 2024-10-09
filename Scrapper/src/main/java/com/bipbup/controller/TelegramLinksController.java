package com.bipbup.controller;

import com.bipbup.controller.dto.request.AddLinkRequest;
import com.bipbup.controller.dto.request.RemoveLinkRequest;
import com.bipbup.controller.dto.responce.LinkResponse;
import com.bipbup.controller.dto.responce.ListLinksResponse;
import com.bipbup.service.link.AddLinkService;
import com.bipbup.service.link.DeleteLinkService;
import com.bipbup.service.link.GetAllTrackedLinksService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/links")
public class TelegramLinksController {

    private final GetAllTrackedLinksService getAllTrackedLinksService;

    private final AddLinkService addLinkService;

    private final DeleteLinkService deleteLinkService;

    @GetMapping
    public ListLinksResponse getLinks(
            @Valid
            @Min(value = 0, message = "ID should be more or equal 0")
            @RequestHeader("Tg-Chat-Id")
            long tgChatId
    ) {
        return getAllTrackedLinksService.getAllTrackedLinks(tgChatId);
    }

    @PostMapping
    public LinkResponse postLinks(
            @Valid
            @Min(value = 0, message = "ID should be more or equal 0")
            @RequestHeader("Tg-Chat-Id")
            long tgChatId,
            @RequestBody
            AddLinkRequest addLinkRequest
    ) {
        return addLinkService.addLink(tgChatId, addLinkRequest);
    }

    @DeleteMapping
    public LinkResponse postLinks(
            @Valid
            @Min(value = 0, message = "ID should be more or equal 0")
            @RequestHeader("Tg-Chat-Id")
            long tgChatId,
            @RequestBody
            RemoveLinkRequest removeLinkRequest
    ) {
        return deleteLinkService.deleteLink(tgChatId, removeLinkRequest);
    }
}
