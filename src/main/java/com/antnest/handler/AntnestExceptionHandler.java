package com.antnest.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AntnestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorMessageResponse> handleException(AntnestException e){

        ErrorMessageResponse error = new ErrorMessageResponse(e.getCode(), e.getMessage(), System.currentTimeMillis());

        HttpStatus httpStatus = HttpStatus.valueOf(e.getCode());
        return new ResponseEntity<>(error, httpStatus);
    }
}
