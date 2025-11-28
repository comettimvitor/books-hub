package com.substitutive.booksHub.domain.models;

/**
 * Model para relatorio de 20 livros mais emprestados.
 *
 * @param id
 * @param title
 * @param author
 * @param isbn
 * @param totalLoans
 */
public record MostBorrowedBook(
        Long id,
        String title,
        String author,
        String isbn,
        int totalLoans
) {
}
