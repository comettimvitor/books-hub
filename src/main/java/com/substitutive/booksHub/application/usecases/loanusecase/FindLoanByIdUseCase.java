package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.domain.exceptions.LoanNotFoundException;
import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FindLoanByIdUseCase {
    private final LoanDomainRepository loanDomainRepository;

    @Transactional
    public LoanResponseDto execute(Long id) {
        return loanDomainRepository.findById(id).map(LoanResponseDto::fromDomain).orElseThrow(() -> new LoanNotFoundException("Loan not found."));
    }
}
