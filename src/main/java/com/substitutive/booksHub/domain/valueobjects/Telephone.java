package com.substitutive.booksHub.domain.valueobjects;

import com.substitutive.booksHub.domain.exceptions.InvalidTelephoneException;

public record Telephone(String value) {
    public Telephone {
        if (value == null || value.isBlank()) {
            throw new InvalidTelephoneException("Telephone can't be null or empty.");
        }

        String regex = "^(\\+\\d{1,3}\\s?)?(\\(?\\d{2}\\)?\\s?)?\\d{4,5}-?\\d{4}$";

        if (!value.matches(regex)) {
            throw new InvalidTelephoneException("Invalid telephone. Ex: (27) 99999-9999 or +55 27 99999-9999");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
