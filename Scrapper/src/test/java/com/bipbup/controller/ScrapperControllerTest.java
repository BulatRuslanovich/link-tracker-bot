package com.bipbup.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.yaml")
class ScrapperControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String TEST_LINK = """
            {
                "link": "https://lol.com"
            }
            """;

    @Test
    @DisplayName("Chat POST: Correct request")
    void postChatCorrect() throws Exception {
        // given
        long id = 1;

        // when
        mockMvc.perform(post("/tg-chat/{id}", id))
                // then
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Chat POST: Incorrect request")
    void postChatIncorrect() throws Exception {
        // given
        long id = -1;

        // when
        mockMvc.perform(post("/tg-chat/{id}", id))
                // then
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Chat DELETE: Correct request")
    void deleteChatCorrect() throws Exception {
        // given
        long id = 1;

        // when
        mockMvc.perform(delete("/tg-chat/{id}", id))
                // then
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Chat DELETE: Incorrect request")
    void deleteChatIncorrect() throws Exception {
        // given
        long id = -1;

        // when
        mockMvc.perform(delete("/tg-chat/{id}", id))
                // then
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Links GET: Correct request")
    void getLinksCorrect() throws Exception {
        // when
        mockMvc.perform(get("/links")
                        .header("Tg-Chat-Id", "1"))
                // then
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Links GET: Incorrect request")
    void getLinksIncorrect() throws Exception {
        // when
        mockMvc.perform(get("/links")
                .header("Tg-Chat-Id", "-1"))
                // then
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Links POST: Correct request")
    void postLinksCorrect() throws Exception {
        // when
        mockMvc.perform(post("/links")
                        .header("Tg-Chat-Id", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TEST_LINK))
                // then
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Links POST: Incorrect request")
    void postLinksIncorrect() throws Exception {
        // when
        mockMvc.perform(post("/links")
                        .header("Tg-Chat-Id", "-1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TEST_LINK))
                // then
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Links DELETE: Correct request")
    void deleteLinksCorrect() throws Exception {
        // when
        mockMvc.perform(delete("/links")
                        .header("Tg-Chat-Id", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TEST_LINK))
                // then
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Links DELETE: Incorrect request")
    void deleteLinksIncorrect() throws Exception {
        // when
        mockMvc.perform(delete("/links")
                        .header("Tg-Chat-Id", "-1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TEST_LINK))
                // then
                .andExpect(status().isBadRequest());
    }
}