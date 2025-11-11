package com.substitutive.booksHub.interfaces.requests;

import com.substitutive.booksHub.application.dtos.bookdto.BookRequestDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookRequest {
    private String title;
    private String author;
    private String isbn;

    public BookRequestDto toDTO() {
        return new BookRequestDto(title, author, isbn);
    }
}
