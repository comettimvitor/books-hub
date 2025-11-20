package com.substitutive.booksHub.domain.exceptions;

public class UserAlreadyExistsException extends RuntimeException implements DomainException {

    public UserAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatus() {
        return 409;
    }
}
