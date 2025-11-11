package com.substitutive.booksHub.domain.exceptions;

public class InvalidIsbnException extends RuntimeException {
    public InvalidIsbnException(String message) {
        super(message);
    }
}
