package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.domain.entities.Loan;
import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateLoanUseCase {
    private final LoanDomainRepository loanDomainRepository;

    public LoanResponseDto execute(Long id, Loan loan) {
        Loan savedLoan = loanDomainRepository.update(id, loan);
        return LoanResponseDto.fromDomain(savedLoan);
    }
}
