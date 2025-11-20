package com.substitutive.booksHub.domain.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidCpfException extends RuntimeException implements DomainException{
    public InvalidCpfException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatus() {
        return HttpStatus.BAD_REQUEST.value();
    }
}
