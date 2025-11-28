package com.substitutive.booksHub.application.dtos.bookdto;

import com.substitutive.booksHub.domain.models.MostBorrowedBook;

/**
 * DTO de resposta para livros mais emprestados.
 *
 * <p>Contém informações sobre o livro e o total de vezes que ele foi emprestado.
 */
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
