package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Caso de uso responsável por buscar todos os livros cadastrados no sistema.
 *
 * <p>Retorna uma lista completa de livros, independentemente do status de disponibilidade.
 */
@Service
@RequiredArgsConstructor
public class FindAllBooksUseCase {
    private final BookDomainRepository bookDomainRepository;

    public List<BookResponseDto> execute() {
        return bookDomainRepository.findAll().stream().map(BookResponseDto::fromDomain).toList();
    }
}
