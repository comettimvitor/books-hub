package com.substitutive.booksHub.domain.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidEmailException extends RuntimeException implements DomainException{
    public InvalidEmailException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
