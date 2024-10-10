package com.bipbup.exception.advice;

import com.bipbup.controller.dto.response.ApiErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestControllerAdvice
public class UpdateExceptionsAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse badRequest(MethodArgumentNotValidException ex) {
        return ApiErrorResponse.builder()
                .description("Incorrect parameters of request")
                .code(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .exceptionName(ex.getObjectName())
                .exceptionMessage(ex.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .collect(Collectors.joining(", ")))
                .stackTrace(Arrays.stream(ex.getStackTrace()).map(StackTraceElement::toString).toList())
                .build();
    }
}
