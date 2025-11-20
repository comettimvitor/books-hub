package com.substitutive.booksHub.domain.exceptions;

import org.springframework.http.HttpStatus;

public class LoanNotFoundException extends RuntimeException implements DomainException{
    public LoanNotFoundException(String message) {
        super(message);
    }

    @Override
    public int getHttpStatus() {
        return HttpStatus.NOT_FOUND.value();
    }
}
