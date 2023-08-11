package com.personal.exception.handler;

import com.personal.exception.exception.ResourceNotFoundException;
import com.personal.exception.model.ErrorModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ErrorModel> resourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorModel model = new ErrorModel(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(model, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorModel> globalExceptionHandler(Exception exception, WebRequest request) {
        ErrorModel model = new ErrorModel(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                exception.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(model, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
