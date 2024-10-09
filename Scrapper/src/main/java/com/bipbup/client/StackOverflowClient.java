package com.bipbup.client;

import com.bipbup.dto.StackOverflowQuestionDTO;
import com.bipbup.dto.StackOverflowResponseDTO;
import com.bipbup.parser.StackOverflowLinkParse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class StackOverflowClient {

    private static final String DEFAULT_STACKOVERFLOW_URL = "https://api.stackexchange.com/2.3";

    private final WebClient webClient;

    public StackOverflowClient() {
        this(DEFAULT_STACKOVERFLOW_URL);
    }

    public StackOverflowClient(String baseUri) {
        this.webClient = WebClient.create(baseUri);
    }

    Mono<StackOverflowQuestionDTO> fetchQuestionsInfo(String link) {
        return webClient.get()
                .uri(StackOverflowLinkParse.parse(link))
                .retrieve()
                .bodyToMono(StackOverflowResponseDTO.class)
                .flatMap(response -> Mono.justOrEmpty(response.getItems().getFirst()));
    }
}
