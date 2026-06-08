package com.practice.demo.api;

import com.practice.demo.exception.InvalidDataFound;
import com.practice.demo.exception.NotFoundException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @Getter
    static class Error {

        private final String reason;
        private final String message;

        Error(String reason, String message) {
            this.reason = reason;
            this.message = message;
        }
    }

    @ExceptionHandler(InvalidDataFound.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleInvalidDataException(
            InvalidDataFound ex){

        log.warn(ex.getMessage());

        return new Error(
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleNotFoundException(
            NotFoundException ex){

        log.warn(ex.getMessage());

        return new Error(
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleGlobalException(
            Exception ex){

        log.error(ex.getMessage());

        return new Error(
                HttpStatus.INTERNAL_SERVER_ERROR
                        .getReasonPhrase(),
                ex.getMessage());
    }
}