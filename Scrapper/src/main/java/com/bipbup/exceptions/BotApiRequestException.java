package com.bipbup.exceptions;

import com.bipbup.controller.dto.responce.ApiErrorResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BotApiRequestException extends RuntimeException {
    private final ApiErrorResponse apiErrorResponse;
}
