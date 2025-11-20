package com.substitutive.booksHub.domain.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException implements DomainException{
    public UserNotFoundException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatus() {
        return HttpStatus.NOT_FOUND.value();
    }
}
