package com.challenge.arcam.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {
    @ExceptionHandler(value = {NullPointerException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorModel deniedPermissionException(NullPointerException ex){
        return new ErrorModel("001","Error, valor nuelo.");
    }

    @ExceptionHandler(value = {ExceptionArcam.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorModel ExceptionArcam(ExceptionArcam ex) {
        return ex.getError();
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String internalServerError(Exception ex){
        return "Internal Error";
    }
}
