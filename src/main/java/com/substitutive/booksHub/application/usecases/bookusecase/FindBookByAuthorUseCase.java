package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindBookByAuthorUseCase {
    private final BookRepository bookRepository;

    public List<BookResponseDto> execute(String author) {
        return bookRepository.findByAuthor(author).stream().map(BookResponseDto::fromDomain).toList();
    }
}
