package com.bipbup.client;

import com.bipbup.dto.GitHubReposDTO;
import com.bipbup.parser.GitHubLinkParse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class GitHubClient {

    private static final String DEFAULT_GITHUB_URL = "https://api.github.com";

    private final WebClient webClient;

    public GitHubClient() {
        this(DEFAULT_GITHUB_URL);
    }

    public GitHubClient(String baseUri) {
        this.webClient = WebClient.create(baseUri);
    }

    public Mono<GitHubReposDTO> fetchReposInfo(String link) {
        return webClient.get()
                .uri(GitHubLinkParse.parse(link))
                .retrieve()
                .bodyToMono(GitHubReposDTO.class);
    }
}
