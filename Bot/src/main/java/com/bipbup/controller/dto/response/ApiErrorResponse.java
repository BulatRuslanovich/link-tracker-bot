package com.bipbup.controller.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ApiErrorResponse(
        String code,
        String description,
        String exceptionName,
        String exceptionMessage,
        List<String> stackTrace
) {
}
