package com.bipbup.api;

import com.bipbup.api.dto.response.LinkResponse;
import com.bipbup.api.dto.response.ListLinksResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;


class ScrapperClientTest {

    private static final String LIST_LINKS_RESPONSE = """
                {
                  "links": [
                    {
                      "id": 1,
                      "url": "https://lol.com"
                    }
                  ],
                  "size": 1
                }
            """;
    private static final String LINK_RESPONSE = """
            {
                "id": 1,
                "url": "https://lol.com"
            }
            """;
    private WireMockServer wireMockServer;

    @BeforeEach
    public void setup() {
        wireMockServer = new WireMockServer();
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());
    }

    @AfterEach
    public void teardown() {
        wireMockServer.stop();
    }

    @Test
    @DisplayName("Sending request to add a chat (Scrapper)")
    void postChatScrapper() {
        // given
        stubFor(post(urlEqualTo("/tg-chat/1"))
                .willReturn(aResponse().withStatus(OK.value())));
        ScrapperClient scrapperClient = new ScrapperClient(wireMockServer.baseUrl());

        // when
        scrapperClient.postTelegramChat(1);

        // then
        WireMock.verify(1, WireMock.postRequestedFor(urlEqualTo("/tg-chat/1")));
    }

    @Test
    @DisplayName("Sending request to delete a chat (Scrapper)")
    void deleteChatScrapper() {
        // given
        stubFor(delete(urlEqualTo("/tg-chat/1"))
                .willReturn(aResponse().withStatus(OK.value())));
        ScrapperClient scrapperClient = new ScrapperClient(wireMockServer.baseUrl());

        // when
        scrapperClient.deleteTelegramChat(1);

        // then
        WireMock.verify(1, WireMock.deleteRequestedFor(urlEqualTo("/tg-chat/1")));
    }

    @Test
    @DisplayName("Sending request to get links (Scrapper)")
    void getLinksScrapper() {
        // given
        stubFor(get(urlEqualTo("/links"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", "application/json")
                        .withBody(LIST_LINKS_RESPONSE)));
        ScrapperClient scrapperClient = new ScrapperClient(wireMockServer.baseUrl());

        // when
        var linkUpdateRequest = scrapperClient.getLinks(1);

        // then
        assertThat(linkUpdateRequest).isEqualTo(getListLinksResponseObj());
    }

    @SneakyThrows
    private ListLinksResponse getListLinksResponseObj() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(ScrapperClientTest.LIST_LINKS_RESPONSE, ListLinksResponse.class);
    }

    @Test
    @DisplayName("Sending request to add a link (Scrapper)")
    void postLinkScrapper() {
        // given
        stubFor(post(urlEqualTo("/links"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", "application/json")
                        .withBody(LINK_RESPONSE)));
        ScrapperClient scrapperClient = new ScrapperClient(wireMockServer.baseUrl());

        // when
        var linkUpdateRequest = scrapperClient.postLinks(1, null);

        // then
        assertThat(linkUpdateRequest).isEqualTo(getLinkResponseObj());
    }

    @Test
    @DisplayName("Sending request to delete a link (Scrapper)")
    void deleteLinkScrapper() {
        // given
        stubFor(delete(urlEqualTo("/links"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", "application/json")
                        .withBody(LINK_RESPONSE)));
        ScrapperClient scrapperClient = new ScrapperClient(wireMockServer.baseUrl());

        // when
        var linkUpdateRequest = scrapperClient.deleteLinks(1, null);

        // then
        assertThat(linkUpdateRequest).isEqualTo(getLinkResponseObj());
    }

    @SneakyThrows
    private LinkResponse getLinkResponseObj() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(ScrapperClientTest.LINK_RESPONSE, LinkResponse.class);
    }
}