package com.bipbup.exceptions.handler;

import com.bipbup.controller.dto.responce.ApiErrorResponse;
import com.bipbup.exceptions.ApiErrorResponseException;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ScrapperExceptionAdvice {

    @ExceptionHandler(HandlerMethodValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse badRequest(HandlerMethodValidationException exception) {
        return ApiErrorResponse.builder()
                .description("Incorrect parameters of request")
                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .exceptionName(HttpStatus.BAD_REQUEST.name())
                .exceptionMessage(exception.getAllErrors()
                        .stream()
                        .map(MessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.joining(", ")))
                .stackTrace(Arrays.stream(exception.getStackTrace()).map(StackTraceElement::toString).toList())
                .build();
    }

    @ExceptionHandler(value = ApiErrorResponseException.class)
    public ResponseEntity<ApiErrorResponse> apiException(ApiErrorResponseException exception) {
        return new ResponseEntity<>(exception.toApiErrorResponse(exception), exception.getHttpStatus());
    }
}
