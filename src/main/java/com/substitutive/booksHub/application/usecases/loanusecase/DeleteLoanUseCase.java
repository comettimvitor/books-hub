package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteLoanUseCase {
    private final LoanDomainRepository loanDomainRepository;

    public void execute(Long id) {
        loanDomainRepository.delete(id);
    }
}
