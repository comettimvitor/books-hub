package com.substitutive.booksHub.domain.exceptions;

import org.springframework.http.HttpStatus;

public class BorrowedBookException extends RuntimeException implements DomainException{
    public BorrowedBookException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
