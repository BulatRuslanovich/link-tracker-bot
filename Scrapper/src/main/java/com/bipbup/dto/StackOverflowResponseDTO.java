package com.bipbup.dto;

import lombok.Data;

import java.util.List;

@Data
public class StackOverflowResponseDTO {
    private List<StackOverflowQuestionDTO> items;
}
