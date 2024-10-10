package com.bipbup.api.bot;


import com.bipbup.api.bot.dto.LinkUpdateRequest;
import com.bipbup.controller.dto.responce.ApiErrorResponse;
import com.bipbup.exceptions.BotApiRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;


public class BotClient {

    private final BotApi service;

    public BotClient(String baseUrl) {
        WebClient webClient = WebClient.builder()
                .defaultStatusHandler(
                        HttpStatusCode::isError,
                        response -> response.toEntity(ApiErrorResponse.class)
                                .map(responseEntity -> new BotApiRequestException(
                                        responseEntity.getBody(),
                                        (HttpStatus) responseEntity.getStatusCode()))
                )
                .baseUrl(baseUrl)
                .build();
        var adapter = WebClientAdapter.create(webClient);
        var factory = HttpServiceProxyFactory.builderFor(adapter).build();
        service = factory.createClient(BotApi.class);
    }

    public void updateBot(LinkUpdateRequest linkUpdateRequest) {
        service.updateBot(linkUpdateRequest);
    }
}
