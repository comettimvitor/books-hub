package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.MostBorrowedBooksResponseDto;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Caso de uso responsável por recuperar os livros mais emprestados.
 *
 * <p>Retorna uma lista dos livros com maior número de empréstimos, ordenada do mais para o menos emprestado.
 */
@Service
@RequiredArgsConstructor
public class MostBorrowedBooksUseCase {
    private final BookDomainRepository bookDomainRepository;

    public List<MostBorrowedBooksResponseDto> execute() {
        return bookDomainRepository.mostBorrowedBooks().stream().map(MostBorrowedBooksResponseDto::fromDomain).toList();
    }
}
