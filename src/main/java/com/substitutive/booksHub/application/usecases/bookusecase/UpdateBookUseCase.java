package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.exceptions.IsbnAlreadyExistsException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * Caso de uso responsável por atualizar os dados de um livro existente.
 *
 * <p>Verifica se já existe um livro com o mesmo ISBN antes de realizar a atualização.
 * Se houver um livro com o mesmo ISBN, lança {@link IsbnAlreadyExistsException}.
 */
@Service
@RequiredArgsConstructor
public class UpdateBookUseCase {
    private final BookDomainRepository bookDomainRepository;

    public BookResponseDto execute(Long id, Book book) {

        bookDomainRepository.findByIsbn(book.getIsbn())
                .ifPresent(bookExists -> {
                    throw new IsbnAlreadyExistsException("Cannot create new book with such ISBN, already exists.");
                });

        var updateBook = bookDomainRepository.update(id, book);
        return BookResponseDto.fromDomain(updateBook);
    }
}
