package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllLoansByBookUseCase {
    private final LoanDomainRepository loanDomainRepository;

    public List<LoanResponseDto> execute(Long bookId) {
        return loanDomainRepository.findAllByBookId(bookId).stream().map(LoanResponseDto::fromDomain).toList();
    }
}
