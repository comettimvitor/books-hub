package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateBookUseCase {
    private final BookRepository bookRepository;

    public BookResponseDto execute(Long id, Book book) {
        var updateBook = bookRepository.update(id, book);
        return BookResponseDto.fromDomain(updateBook);
    }
}
