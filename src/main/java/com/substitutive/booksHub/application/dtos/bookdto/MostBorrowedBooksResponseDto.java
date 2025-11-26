package com.substitutive.booksHub.application.dtos.bookdto;

import com.substitutive.booksHub.domain.models.MostBorrowedBook;

public record MostBorrowedBooksResponseDto(
        Long id,
        String title,
        String author,
        String isbn,
        int totalLoans
) {
    public static MostBorrowedBooksResponseDto fromDomain(MostBorrowedBook mostBorrowedBook) {
        return new MostBorrowedBooksResponseDto(
                mostBorrowedBook.id(),
                mostBorrowedBook.title(),
                mostBorrowedBook.author(),
                mostBorrowedBook.isbn(),
                mostBorrowedBook.totalLoans()
        );
    }
}
