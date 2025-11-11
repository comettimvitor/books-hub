package com.substitutive.booksHub.application.dtos.bookdto;

public record BookRequestDto(
        String title,
        String author,
        String isbn
) {
}
