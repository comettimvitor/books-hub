package com.substitutive.booksHub.domain.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidIsbnException extends RuntimeException implements DomainException{
    public InvalidIsbnException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
