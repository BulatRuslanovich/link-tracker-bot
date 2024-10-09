package com.bipbup.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GitHubLinkParseTest {

    @ParameterizedTest
    @CsvSource(value = {
            "https://github.com/bulatruslanovich/LolCat, /repos/bulatruslanovich/LolCat",
            "https://github.com/bulatruslanovich/LolCat/?queryParams, /repos/bulatruslanovich/LolCat",
            "https://github.com/bulatruslanovich/LolCat?queryParams, /repos/bulatruslanovich/LolCat"
    })
    @DisplayName("Get correct link after parsing for GitHub")
    void parse_returnsUri(String input, String output) {
        // when
        var link = GitHubLinkParse.parse(input);

        // then
        assertEquals(link, output);
    }
}