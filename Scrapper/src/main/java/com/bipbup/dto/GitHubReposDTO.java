package com.bipbup.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class GitHubReposDTO {

    @JsonProperty("name")
    private String reposName;

    @JsonProperty("updated_at")
    private OffsetDateTime updateTime;
}
