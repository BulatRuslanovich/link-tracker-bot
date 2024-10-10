package com.bipbup.api;

import com.bipbup.api.dto.request.AddLinkRequest;
import com.bipbup.api.dto.request.RemoveLinkRequest;
import com.bipbup.api.dto.response.LinkResponse;
import com.bipbup.api.dto.response.ListLinksResponse;
import com.bipbup.controller.dto.response.ApiErrorResponse;
import com.bipbup.exception.ScrapperApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

public class ScrapperClient {

    private final ScrapperApi service;

    public ScrapperClient(String baseUri) {
        var webClient = WebClient.builder()
                .defaultStatusHandler(HttpStatusCode::isError,
                        response -> response.toEntity(ApiErrorResponse.class)
                                .map(entity -> new ScrapperApiRequestException(
                                        entity.getBody(),
                                        (HttpStatus) entity.getStatusCode()
                                )))
                .baseUrl(baseUri)
                .build();
        var adapter = WebClientAdapter.create(webClient);
        var factory = HttpServiceProxyFactory.builderFor(adapter).build();
        service = factory.createClient(ScrapperApi.class);
    }

    public void postTelegramChat(long id) throws ScrapperApiRequestException {
        service.postTgChat(id);
    }

    public void deleteTelegramChat(long id) throws ScrapperApiRequestException {
        service.deleteTgChat(id);
    }

    public ListLinksResponse getLinks(long id) throws ScrapperApiRequestException {
        return service.getLinks(id);
    }

    public LinkResponse postLinks(long id, AddLinkRequest addLinkRequest) throws ScrapperApiRequestException {
        return service.postLink(id, addLinkRequest);
    }

    public LinkResponse deleteLinks(long id, RemoveLinkRequest removeLinkRequest) throws ScrapperApiRequestException {
        return service.deleteLink(id, removeLinkRequest);
    }
}
