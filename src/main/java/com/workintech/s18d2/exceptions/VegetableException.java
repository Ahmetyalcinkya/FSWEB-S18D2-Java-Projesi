package com.workintech.s18d2.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class VegetableException extends RuntimeException {
    private HttpStatus status;

    public VegetableException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
