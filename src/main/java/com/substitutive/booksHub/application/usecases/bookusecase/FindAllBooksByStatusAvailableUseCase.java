package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllBooksByStatusAvailableUseCase {
    private final BookRepository bookRepository;

    public List<BookResponseDto> execute() {
        return bookRepository.findAllByStatusAvailable().stream().map(BookResponseDto::fromDomain).toList();
    }
}
