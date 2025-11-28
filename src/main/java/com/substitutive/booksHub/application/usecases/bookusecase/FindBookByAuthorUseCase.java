package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Caso de uso responsável por buscar livros de um determinado autor.
 *
 * <p>Retorna todos os livros que correspondem ao autor informado.
 */
@Service
@RequiredArgsConstructor
public class FindBookByAuthorUseCase {
    private final BookDomainRepository bookDomainRepository;

    public List<BookResponseDto> execute(String author) {
        return bookDomainRepository.findByAuthor(author).stream().map(BookResponseDto::fromDomain).toList();
    }
}
