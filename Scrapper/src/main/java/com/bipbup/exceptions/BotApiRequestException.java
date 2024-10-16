package com.bipbup.exceptions;

import com.bipbup.controller.dto.responce.ApiErrorResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class BotApiRequestException extends RuntimeException {
    private final ApiErrorResponse apiErrorResponse;
    private final HttpStatus httpStatus;

    public String getShortErrorMessage() {
        return "Status code: " + apiErrorResponse.code() + "; Message: " + apiErrorResponse.exceptionMessage();
    }
}
