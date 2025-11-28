package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BorrowedBooksResponseDto;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Caso de uso responsável por recuperar os livros que estão atualmente emprestados.
 *
 * <p>Este caso de uso consulta o repositório de livros para obter todos os livros
 * que estão em situação de empréstimo ativo e retorna uma lista de DTOs para a camada de apresentação.
 */
@Service
@RequiredArgsConstructor
public class BorrowedBooksUseCase {
    private final BookDomainRepository bookDomainRepository;

    public List<BorrowedBooksResponseDto> execute() {
        return bookDomainRepository.borrowedBooks().stream().map(BorrowedBooksResponseDto::fromDomain).toList();
    }
}
