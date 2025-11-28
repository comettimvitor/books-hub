package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Caso de uso responsável por buscar todos os livros associados a um determinado empréstimo.
 *
 * <p>Recebe o ID de um empréstimo e retorna a lista de livros relacionados a ele.
 */
@Service
@RequiredArgsConstructor
public class FindAllBooksByLoanId {
    private final BookDomainRepository bookDomainRepository;

    public List<BookResponseDto> execute(Long loanId) {
        return bookDomainRepository.findAllBooksByLoanId(loanId).stream().map(BookResponseDto::fromDomain).toList();
    }
}
