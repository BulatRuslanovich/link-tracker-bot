package com.bipbup.api.bot;


import com.bipbup.api.bot.dto.LinkUpdateRequest;
import com.bipbup.controller.dto.responce.ApiErrorResponse;
import com.bipbup.exceptions.BotApiRequestException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Log4j2
public class BotModuleClient {

    private final BotUpdateService service;

    public BotModuleClient() {
        this("http://localhost:8090");
    }

    public BotModuleClient(String baseUrl) {
        WebClient webClient = WebClient.builder()
                .defaultStatusHandler(
                        HttpStatusCode::isError,
                        response -> response.toEntity(ApiErrorResponse.class)
                                .map(responseEntity -> new BotApiRequestException(responseEntity.getBody()))
                )
                .baseUrl(baseUrl)
                .build();
        WebClientAdapter adapter = WebClientAdapter.create(webClient);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();
        service = factory.createClient(BotUpdateService.class);
        updateBot(null);
    }

    public void updateBot(LinkUpdateRequest linkUpdateRequest) {
        try {
            service.updateBot(linkUpdateRequest);
        } catch (BotApiRequestException e) {
            log.error("{}{}", e.getApiErrorResponse().code(), e.getApiErrorResponse().exceptionMessage());
        }
    }
}
