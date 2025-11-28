package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * Caso de uso responsável por buscar um livro pelo seu ID.
 *
 * <p>Se o livro não for encontrado, lança uma exceção {@link com.substitutive.booksHub.domain.exceptions.BookNotFoundException}.
 */
@Service
@RequiredArgsConstructor
public class FindBookByIdUseCase {
    private final BookDomainRepository bookDomainRepository;

    public BookResponseDto execute(Long id) {
        return bookDomainRepository.findById(id).map(BookResponseDto::fromDomain)
                .orElseThrow(() -> new BookNotFoundException("Book not found."));
    }
}
