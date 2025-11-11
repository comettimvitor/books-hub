package com.substitutive.booksHub.domain.valueobjects;

import com.substitutive.booksHub.domain.exceptions.InvalidCpfException;

public record CPF(String value) {
    public CPF {
        if (value == null || value.isBlank()) {
            throw new InvalidCpfException("CPF can't be null or empty.");
        }

        String numericCPF = value.replaceAll("\\D", "");

        if (!numericCPF.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF must contain 11 numeric digits.");
        }

        value = numericCPF;
    }

    @Override
    public String toString() {
        return value.substring(0, 3) + "." +
                value.substring(3, 6) + "." +
                value.substring(6, 9) + "-" +
                value.substring(9);
    }
}
