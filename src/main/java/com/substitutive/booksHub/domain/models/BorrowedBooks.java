package com.substitutive.booksHub.domain.models;

import java.util.Date;

public record BorrowedBooks(
        Long id,
        String title,
        String author,
        String isbn,
        Date dueDate
) {
}
