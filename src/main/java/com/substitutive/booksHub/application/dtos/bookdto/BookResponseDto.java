package com.substitutive.booksHub.application.dtos.bookdto;

import com.substitutive.booksHub.domain.entities.Book;
/**
 * DTO de resposta para informações de um livro.
 *
 * <p>Representa os dados retornados para o cliente após operações de criação,
 * atualização ou consulta de {@link Book}.
 */
public record BookResponseDto(
        Long id,
        String title,
        String author,
        String isbn,
        String status,
        boolean isAvailable
) {
    public static BookResponseDto fromDomain(Book book) {
        return new BookResponseDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn().toString(),
                book.getStatus().name(),
                book.isAvailable()
        );
    }
}
