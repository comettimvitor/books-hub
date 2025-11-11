package com.substitutive.booksHub.domain.valueobjects;

import com.substitutive.booksHub.domain.exceptions.InvalidEmailException;

public record Email(String value) {
    public Email {
        if (value == null || !value.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidEmailException("Invalid E-mail.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
