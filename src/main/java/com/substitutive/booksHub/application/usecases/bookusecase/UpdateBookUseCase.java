package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.exceptions.IsbnAlreadyExistsException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
