package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.domain.entities.Loan;
import com.substitutive.booksHub.domain.exceptions.LoanNotFoundException;
import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReturnLoanUseCase {
    private final LoanDomainRepository loanDomainRepository;

    @Transactional
    public LoanResponseDto execute(Long id) {
        Loan loan = loanDomainRepository.findById(id).orElseThrow(() -> new LoanNotFoundException("Loan not found."));
        loan.returnBook(LocalDate.now());

        Loan savedLoan = loanDomainRepository.update(loan);
        return LoanResponseDto.fromDomain(savedLoan);
    }
}
