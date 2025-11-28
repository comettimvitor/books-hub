package com.substitutive.booksHub.application.dtos.bookdto;
/**
 * DTO de requisição para criar ou atualizar um livro.
 *
 * <p>Contém os dados necessários para a criação ou atualização de um {@code Book}.
 */
public record BookRequestDto(
        String title,
        String author,
        String isbn
) {}
