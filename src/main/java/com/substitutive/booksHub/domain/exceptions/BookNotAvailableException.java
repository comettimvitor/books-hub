package com.substitutive.booksHub.domain.exceptions;

import org.springframework.http.HttpStatus;

public class BookNotAvailableException extends RuntimeException implements DomainException{
    public BookNotAvailableException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
