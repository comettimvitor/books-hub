package com.substitutive.booksHub.application.dtos.bookdto;

import com.substitutive.booksHub.domain.models.BorrowedBooks;

import java.util.Date;
/**
 * DTO de resposta para livros que foram emprestados.
 *
 * <p>Contém informações sobre o livro emprestado, incluindo a data de devolução prevista.
 */
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
