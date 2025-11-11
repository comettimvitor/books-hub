package com.substitutive.booksHub.domain.exceptions;

public class InvalidTelephoneException extends RuntimeException {
    public InvalidTelephoneException(String message) {
        super(message);
    }
}
