package com.api.bci.users.infrastructure.controller.handler;

import com.api.bci.users.domain.validation.exception.EmailFormatException;
import com.api.bci.users.domain.validation.exception.ExistEmailException;
import com.api.bci.users.domain.validation.exception.RequiredValueNoNullOrNoEmptyException;
import com.api.bci.users.domain.validation.exception.UserNotFoundException;
import com.api.bci.users.infrastructure.controller.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler
    private ResponseEntity<ErrorResponseDto> sendResponse(Exception exception) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(exception.getMessage());

        if (exception instanceof RequiredValueNoNullOrNoEmptyException ||
                exception instanceof EmailFormatException) {
            return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
        } else if (exception instanceof ExistEmailException) {
            return new ResponseEntity<>(errorResponseDto, HttpStatus.CONFLICT);
        } else if (exception instanceof UserNotFoundException) {
            return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
