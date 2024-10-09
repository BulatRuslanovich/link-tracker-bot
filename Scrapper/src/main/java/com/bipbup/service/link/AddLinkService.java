package com.bipbup.service.link;

import com.bipbup.controller.dto.request.AddLinkRequest;
import com.bipbup.controller.dto.responce.LinkResponse;
import com.bipbup.exceptions.LinkAlreadyRegisteredException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class AddLinkService {

    @SneakyThrows(URISyntaxException.class)
    public LinkResponse addLink(long tgChatId, AddLinkRequest addLinkRequest) {

        if (addLinkRequest.link().toString().equals("https://exist.com")) {
            throw new LinkAlreadyRegisteredException("Link is contained in the monitored resources");
        }

        return new LinkResponse(1, new URI("http://lol.com"));
    }
}
