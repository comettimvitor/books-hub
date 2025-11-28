package com.substitutive.booksHub.domain.models;

import java.util.Date;

/**
 * Model para geracao de relatorio de livros que estao emprestados.
 *
 * @param id
 * @param title
 * @param author
 * @param isbn
 * @param dueDate
 */
public record BorrowedBooks(
        Long id,
        String title,
        String author,
        String isbn,
        Date dueDate
) {
}
