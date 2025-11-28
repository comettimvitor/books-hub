package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Caso de uso responsável por buscar todos os livros disponíveis para empréstimo.
 *
 * <p>Retorna a lista de livros cujo status indica que estão disponíveis.
 */
@Service
@RequiredArgsConstructor
public class FindAllBooksByStatusAvailableUseCase {
    private final BookDomainRepository bookDomainRepository;

    public List<BookResponseDto> execute() {
        return bookDomainRepository.findAllByStatusAvailable().stream().map(BookResponseDto::fromDomain).toList();
    }
}
