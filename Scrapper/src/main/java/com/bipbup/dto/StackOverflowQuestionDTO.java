package com.bipbup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class StackOverflowQuestionDTO {

    @JsonProperty("title")
    private String questionText;

    @JsonProperty("last_activity_date")
    private OffsetDateTime updateTime;
}
