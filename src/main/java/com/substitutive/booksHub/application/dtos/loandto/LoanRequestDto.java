package com.substitutive.booksHub.application.dtos.loandto;

import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.entities.Loan;
import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.enums.LoanStatus;

import java.time.LocalDate;
import java.util.List;

public record LoanRequestDto(
        List<Book> books,
        User user,
        LocalDate loanDate,
        LocalDate returnDate,
        LoanStatus status
) {
    public Loan toDomain() {
        return new Loan(
                books,
                user,
                loanDate,
                returnDate,
                status
        );
    }
}
