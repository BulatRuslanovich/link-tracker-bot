package com.bipbup.parser;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GitHubLinkParse {

    public static String parse(String link) {
        var keyWords = link.substring(0, link.contains("?")
                        ? link.indexOf("?")
                        : link.length()).split("/");

        var userName = keyWords[keyWords.length - 2];
        var reposName = keyWords[keyWords.length - 1];

        return String.format("/repos/%s/%s", userName, reposName);
    }
}
