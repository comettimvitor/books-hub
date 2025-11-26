package com.substitutive.booksHub.domain.models;

public record MostBorrowedBook(
        Long id,
        String title,
        String author,
        String isbn,
        int totalLoans
) {
}
