package com.substitutive.booksHub.interfaces.responses;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;

import java.util.List;

public record CreateBookResponse(Long id, String title, String author, String isbn, String status, boolean available) {

    public static CreateBookResponse fromDTO(BookResponseDto dto) {
        return new CreateBookResponse(
                dto.id(),
                dto.title(),
                dto.author(),
                dto.isbn(),
                dto.status(),
                dto.isAvailable()
        );
    }

    public static List<CreateBookResponse> fromDTOList(List<BookResponseDto> dtoList) {
        return dtoList.stream().map(CreateBookResponse::fromDTO).toList();
    }
}
