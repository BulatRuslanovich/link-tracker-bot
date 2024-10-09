package com.bipbup.client;

import com.bipbup.dto.GitHubReposDTO;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.OffsetDateTime;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GitHubClientTest {

    private static final OffsetDateTime TEST_UPDATE_TIME = OffsetDateTime.parse("2024-07-12T15:06:09Z");

    private static final String TEST_USER_NAME = "BulatRuslanovich";

    private static final String TEST_REPOS_NAME = "LolCat";

    private static final String TEST_LINK = "https://github.com/BulatRuslanovich/LolCat";

    private static final String TEST_JSON = """
            {"updated_at": "2010-10-10T10:10:10Z", "name" : "LolCat"}""";

    private WireMockServer wireMockServer;

    private GitHubReposDTO resultDTO;

    @BeforeEach
    void setup() {
        wireMockServer = new WireMockServer();
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());
        resultDTO = new GitHubReposDTO();
        resultDTO.setReposName(TEST_REPOS_NAME);
        resultDTO.setUpdateTime(TEST_UPDATE_TIME);
    }

    @AfterEach
    void teardown() {
        wireMockServer.stop();
    }

    /**
     * Tests the retrieval of repository information from the GitHub API.
     * <p>
     * Note: This test is fragile as it relies on the state of the repository
     * located at <a href="https://github.com/BulatRuslanovich/LolCat">LolCat</a>.
     */
    @Test
    @DisplayName("Get info about repo from GitHub api")
    void fetchReposInfo_returnResultDTO() {
        // given
        stubFor(get(urlEqualTo("/repos/" + TEST_USER_NAME + "/" + TEST_REPOS_NAME))
                .willReturn(aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", "application/json")
                        .withBody(TEST_JSON)));

        var gitHubClient = new GitHubClient();

        // when
        var response = gitHubClient.fetchReposInfo(TEST_LINK);
        var responseData = response.block();

        // then
        assertEquals(responseData, resultDTO);
    }
}