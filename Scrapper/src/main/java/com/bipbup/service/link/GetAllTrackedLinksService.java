package com.bipbup.service.link;

import com.bipbup.controller.dto.responce.LinkResponse;
import com.bipbup.controller.dto.responce.ListLinksResponse;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class GetAllTrackedLinksService {

    @SneakyThrows(URISyntaxException.class)
    public ListLinksResponse getAllTrackedLinks(long tgChatId) {
        return new ListLinksResponse(List.of(new LinkResponse(0, new URI("https://lol.com"))), 1);
    }
}
