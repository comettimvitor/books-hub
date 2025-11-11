package com.substitutive.booksHub.domain.exceptions;

public class BorrowedBookException extends RuntimeException {
    public BorrowedBookException(String message) {
        super(message);
    }
}
