package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookRequestDto;
import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.repositories.BookRepository;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookUseCase {
    private final BookRepository bookRepository;

    public BookResponseDto execute(BookRequestDto request) {
        Book book = new Book(
                null,
                request.title(),
                request.author(),
                new InternationalStandardBookNumber(request.isbn())
        );

        Book saved = bookRepository.save(book);

        return new BookResponseDto(
                saved.getId(),
                saved.getTitle(),
                saved.getAuthor(),
                saved.getIsbn().toString(),
                saved.getStatus().name(),
                saved.isAvailable()
        );
    }
}
