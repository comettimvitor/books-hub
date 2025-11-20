package com.substitutive.booksHub.domain.exceptions;

import org.springframework.http.HttpStatus;

public class BookNotFoundException extends RuntimeException implements DomainException{
    public BookNotFoundException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatus() {
        return HttpStatus.NOT_FOUND.value();
    }
}
