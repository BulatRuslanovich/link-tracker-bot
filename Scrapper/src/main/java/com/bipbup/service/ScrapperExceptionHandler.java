package com.bipbup.service;

import com.bipbup.controller.dto.responce.ApiErrorResponse;
import com.bipbup.exceptions.ChatNotFoundException;
import com.bipbup.exceptions.LinkNotFoundException;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ScrapperExceptionHandler {

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

    @ExceptionHandler(value = ChatNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse chatNotFound(ChatNotFoundException exception) {
        return ApiErrorResponse.builder()
                .description(ChatNotFoundException.DESCRIPTION)
                .code(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .exceptionName(HttpStatus.NOT_FOUND.name())
                .exceptionMessage(exception.getMessage())
                .stackTrace(Arrays.stream(exception.getStackTrace())
                        .map(StackTraceElement::toString)
                        .toList())
                .build();
    }

    @ExceptionHandler(value = LinkNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse linkNotFound(LinkNotFoundException exception) {
        return ApiErrorResponse.builder()
                .description(LinkNotFoundException.DESCRIPTION)
                .code(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .exceptionName(HttpStatus.NOT_FOUND.name())
                .exceptionMessage(exception.getMessage())
                .stackTrace(Arrays.stream(exception.getStackTrace())
                        .map(StackTraceElement::toString)
                        .toList())
                .build();
    }
}
