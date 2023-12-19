package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(FruitException fruitException){
        ErrorResponse fruitErrorResponse = new ErrorResponse(fruitException.getMessage());
        return new ResponseEntity<>(fruitErrorResponse, fruitException.getStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(VegetableException vegetableException){
        ErrorResponse vegetableErrorResponse = new ErrorResponse(vegetableException.getMessage());
        return new ResponseEntity<>(vegetableErrorResponse, vegetableException.getStatus());
    }
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
