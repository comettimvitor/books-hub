package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Caso de uso responsável por buscar todos os empréstimos existentes no sistema.
 *
 * <p>Retorna uma lista de DTOs de resposta ({@link LoanResponseDto}) contendo todos os empréstimos
 * registrados no sistema.
 */
@Service
@RequiredArgsConstructor
public class FindAllLoansUseCase {
    private final LoanDomainRepository loanDomainRepository;

    public List<LoanResponseDto> execute() {
        return loanDomainRepository.findAll().stream().map(LoanResponseDto::fromDomain).toList();
    }
}
