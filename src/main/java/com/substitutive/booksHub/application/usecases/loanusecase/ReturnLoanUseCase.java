package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.entities.Loan;
import com.substitutive.booksHub.domain.enums.LoanStatus;
import com.substitutive.booksHub.domain.exceptions.LoanNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReturnLoanUseCase {
    private final LoanDomainRepository loanDomainRepository;
    private final BookDomainRepository bookDomainRepository;

    @Transactional
    public LoanResponseDto execute(Long id) {
        List<Book> books = bookDomainRepository.findAllBooksByLoanId(id);
        books.forEach(book -> {
            book.endTransaction();
            bookDomainRepository.update(book.getId(), book);
        });

        Loan loan = loanDomainRepository.findById(id).orElseThrow(() -> new LoanNotFoundException("Loan not found."));
        if (LoanStatus.ON_GOING.equals(loan.getStatus())) {
            loan.returnBook();
        }

        Loan savedLoan = loanDomainRepository.returnLoan(loan);
        return LoanResponseDto.fromDomain(savedLoan);
    }
}
