package com.bipbup.client;

import com.bipbup.dto.GitHubReposDTO;
import com.bipbup.parser.GitHubLinkParse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class GitHubClient {

    private static final String DEFAULT_GITHUB_URL = "https://api.github.com";

    private final WebClient webClient;

    public GitHubClient() {
        this.webClient = WebClient.create(DEFAULT_GITHUB_URL);
    }

    public Mono<GitHubReposDTO> fetchReposInfo(String link) {
        return webClient.get()
                .uri(GitHubLinkParse.parse(link))
                .retrieve()
                .bodyToMono(GitHubReposDTO.class);
    }
}
