package com.bipbup.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackOverflowLinkParseTest {
    @ParameterizedTest
    @CsvSource(value = {
            "https://stackoverflow.com/questions/11227809/array, /questions/11227809/?site=stackoverflow",
            "https://stackoverflow.com/questions/11227809/array/?queryParams, /questions/11227809/?site=stackoverflow",
            "https://stackoverflow.com/questions/11227809/array?queryParams, /questions/11227809/?site=stackoverflow"
    })
    @DisplayName("Get correct link after parsing for StackOverflow")
    void parse_returnsUri(String input, String output) {
        // when
        var link = StackOverflowLinkParse.parse(input);

        // then
        assertEquals(link, output);
    }
}