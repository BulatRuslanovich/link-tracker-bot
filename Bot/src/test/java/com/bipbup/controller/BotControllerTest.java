package com.bipbup.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.yml")
class BotControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String TEST_CORRECT_BODY = """
        {
          "id": 1,
          "url": "http://lol.com",
          "description": "Some description",
          "tgChatIds": [43, 456]
        }
        """;

    private static final String TEST_INCORRECT_BODY = """
        {
          "id": -1,
          "url": "http://lol.com",
          "description": "Some description",
          "tgChatIds": [43, 456]
        }
        """;

    @Test
    @DisplayName("Update: POST; Correct request")
    void postUpdateCorrect() throws Exception {
        mockMvc.perform(post("/updates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TEST_CORRECT_BODY))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Update: POST; Incorrect request")
    void postUpdateIncorrect() throws Exception {
        mockMvc.perform(post("/updates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TEST_INCORRECT_BODY))
                .andExpect(status().isBadRequest());
    }
}