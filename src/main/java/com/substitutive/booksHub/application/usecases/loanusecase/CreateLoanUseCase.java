package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.application.dtos.loandto.LoanRequestDto;
import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.domain.entities.Loan;
import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateLoanUseCase {
    private final LoanDomainRepository loanDomainRepository;

    @Transactional
    public LoanResponseDto execute(LoanRequestDto request) {
        Loan loan = request.toDomain();
        Loan saved = loanDomainRepository.save(loan);
        return LoanResponseDto.fromDomain(saved);
    }
}
