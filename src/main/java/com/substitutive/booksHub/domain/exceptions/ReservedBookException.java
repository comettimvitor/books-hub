package com.substitutive.booksHub.domain.exceptions;

import org.springframework.http.HttpStatus;

public class ReservedBookException extends RuntimeException implements DomainException{
    public ReservedBookException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
