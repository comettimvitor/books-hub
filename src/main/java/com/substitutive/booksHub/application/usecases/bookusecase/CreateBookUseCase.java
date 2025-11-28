package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookRequestDto;
import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.enums.BookStatus;
import com.substitutive.booksHub.domain.exceptions.IsbnAlreadyExistsException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
/**
 * Caso de uso responsável por criar um novo livro no sistema.
 *
 * <p>Este caso de uso verifica se o ISBN informado já existe no repositório.
 * Caso exista, lança uma {@link IsbnAlreadyExistsException}. Caso contrário,
 * cria um novo livro com status {@link com.substitutive.booksHub.domain.enums.BookStatus#AVAILABLE}
 * e disponível para empréstimos.
 */
@Service
@RequiredArgsConstructor
public class CreateBookUseCase {
    private final BookDomainRepository bookDomainRepository;

    public BookResponseDto execute(BookRequestDto request) {
        InternationalStandardBookNumber isbn = new InternationalStandardBookNumber(request.isbn());

        bookDomainRepository.findByIsbn(isbn)
                .ifPresent(book -> {
                    throw new IsbnAlreadyExistsException("Cannot create new book with such ISBN, already exists.");
                });

        Book book = new Book(
                null,
                request.title(),
                request.author(),
                isbn,
                BookStatus.AVAILABLE,
                true
        );

        Book saved = bookDomainRepository.save(book);

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
