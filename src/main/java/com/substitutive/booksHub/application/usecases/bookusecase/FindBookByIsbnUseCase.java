package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookRepository;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindBookByIsbnUseCase {
    private final BookRepository bookRepository;

    public BookResponseDto execute(InternationalStandardBookNumber isbn) {
        return bookRepository.findByIsbn(isbn).map(BookResponseDto::fromDomain)
                .orElseThrow(() -> new BookNotFoundException("Book not found."));
    }
}
