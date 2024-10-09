package com.bipbup.service.link;

import com.bipbup.controller.dto.request.RemoveLinkRequest;
import com.bipbup.controller.dto.responce.LinkResponse;
import com.bipbup.exceptions.LinkNotFoundException;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class DeleteLinkService {

    @SneakyThrows
    public LinkResponse deleteLink(long tgChatId, RemoveLinkRequest removeLinkRequest) {
        checkLink(removeLinkRequest.link());

        return new LinkResponse(1, new URI("https://lol.com"));
    }

    private void checkLink(URI link) {
        if (link.toString().equals("https://wrong.com")) {
            throw new LinkNotFoundException("Link not founded");
        }
    }
}
