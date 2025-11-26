package com.substitutive.booksHub.application.dtos.bookdto;

import com.substitutive.booksHub.domain.models.BorrowedBooks;
import com.substitutive.booksHub.domain.models.MostBorrowedBook;

import java.util.Date;

public record BorrowedBooksResponseDto(
        Long id,
        String title,
        String author,
        String isbn,
        Date dueDate
) {
    public static BorrowedBooksResponseDto fromDomain(BorrowedBooks borrowedBooks) {
        return new BorrowedBooksResponseDto(
                borrowedBooks.id(),
                borrowedBooks.title(),
                borrowedBooks.author(),
                borrowedBooks.isbn(),
                borrowedBooks.dueDate()
        );
    }
}
