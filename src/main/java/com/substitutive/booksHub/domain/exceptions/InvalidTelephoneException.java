package com.substitutive.booksHub.domain.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidTelephoneException extends RuntimeException implements DomainException{
    public InvalidTelephoneException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
