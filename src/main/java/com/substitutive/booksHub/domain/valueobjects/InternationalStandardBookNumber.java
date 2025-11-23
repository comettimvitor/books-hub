package com.substitutive.booksHub.domain.valueobjects;

import com.substitutive.booksHub.domain.exceptions.InvalidIsbnException;

public record InternationalStandardBookNumber(String value) {
    public InternationalStandardBookNumber {
        if(value == null || !value.matches("\\d{3}-\\d{2}-\\d{5}-\\d{2}-\\d{1}")) {
            throw new InvalidIsbnException("Invalid ISBN. Valid number example: 111-12-34567-89-0");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
