package com.bipbup.client;

import com.bipbup.dto.StackOverflowQuestionDTO;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StackOverflowClientTest {

    public static final String TEST_QUESTION =
            "Why is processing a sorted array faster than processing an unsorted array?";

    private static final String TEST_LINK =
            "https://stackoverflow.com/questions/11227809/why-is-processing-a-sorted-array-faster-than-processing-an-unsorted-array";

    private static final OffsetDateTime TEST_UPDATE_TIME = OffsetDateTime.parse("2024-01-23T14:58:43Z");

    private static final Integer TEST_ID = 11227809;

    private static final String TEST_JSON = """
            {"items": [{"tags": ["java", "c++", "performance", "cpu-architecture", "branch-prediction"],
                "last_activity_date": 1706021923,
                "title": "Why is processing a sorted array faster than processing an unsorted array?"
            }]}
            """;

    private WireMockServer wireMockServer;

    private StackOverflowQuestionDTO resultDTO;

    @BeforeEach
    public void setup() {
        wireMockServer = new WireMockServer();
        wireMockServer.start();
        WireMock.configureFor("localhost", wireMockServer.port());
        resultDTO = new StackOverflowQuestionDTO();
        resultDTO.setQuestionText(TEST_QUESTION);
        resultDTO.setUpdateTime(TEST_UPDATE_TIME);
    }

    @AfterEach
    public void teardown() {
        wireMockServer.stop();
    }

    @Test
    @DisplayName("Get info about question from StackOverflow api")
    void fetchQuestionsInfo_returnsResultDTO() {
        // given
        stubFor(get(urlEqualTo("/questions/" + TEST_ID + "/?site=stackoverflow"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(TEST_JSON)));

        var stackOverflowClient = new StackOverflowClient(wireMockServer.baseUrl());

        // when
        var response = stackOverflowClient.fetchQuestionsInfo(TEST_LINK);
        var responseData = response.block();

        // then
        assertEquals(responseData, resultDTO);
    }
}