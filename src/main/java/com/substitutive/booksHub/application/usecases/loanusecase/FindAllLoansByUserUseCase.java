package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Caso de uso responsável por buscar todos os empréstimos de um usuário específico.
 *
 * <p>Retorna uma lista de DTOs de resposta ({@link LoanResponseDto}) contendo os empréstimos
 * realizados pelo usuário identificado pelo ID fornecido.
 */
@Service
@RequiredArgsConstructor
public class FindAllLoansByUserUseCase {
    private final LoanDomainRepository loanDomainRepository;

    public List<LoanResponseDto> execute(Long userId) {
        return loanDomainRepository.findAllByUserId(userId).stream().map(LoanResponseDto::fromDomain).toList();
    }
}
