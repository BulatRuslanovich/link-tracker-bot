package com.bipbup.service.link;

import com.bipbup.controller.dto.request.AddLinkRequest;
import com.bipbup.controller.dto.responce.LinkResponse;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class AddLinkService {

    @SneakyThrows
    public LinkResponse addLink(long tgChatId, AddLinkRequest addLinkRequest) {
        return new LinkResponse(1, new URI("http://lol.com"));
    }
}
