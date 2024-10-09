package com.bipbup.parser;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StackOverflowLinkParse {

    public static String parse(String link) {
        var keyWords = link.substring(0, link.contains("?")
                        ? link.indexOf("?")
                        : link.length()).split("/");

        var id = keyWords[keyWords.length - 2];
        return String.format("/questions/%s/?site=stackoverflow", id);
    }
}
