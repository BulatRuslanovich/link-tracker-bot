package com.bipbup.service.link;

import com.bipbup.controller.dto.request.RemoveLinkRequest;
import com.bipbup.controller.dto.responce.LinkResponse;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class DeleteLinkService {

    public LinkResponse deleteLink(long tgChatId, RemoveLinkRequest removeLinkRequest) {
        checkLink(removeLinkRequest.link());
        return null;
    }

    private void checkLink(URI link) {
        return;
    }
}
