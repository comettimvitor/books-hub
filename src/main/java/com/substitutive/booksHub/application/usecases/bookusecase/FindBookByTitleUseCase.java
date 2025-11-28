package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * Caso de uso responsável por buscar um livro pelo seu título.
 *
 * <p>Se o livro não for encontrado, lança uma exceção {@link com.substitutive.booksHub.domain.exceptions.BookNotFoundException}.
 */
@Service
@RequiredArgsConstructor
public class FindBookByTitleUseCase {
    private final BookDomainRepository bookDomainRepository;

    public BookResponseDto execute(String title) {
        return bookDomainRepository.findByBookTitle(title).map(BookResponseDto::fromDomain)
                .orElseThrow(() -> new BookNotFoundException("Book not found."));
    }
}
