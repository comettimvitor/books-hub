package com.substitutive.booksHub.application.dtos.loandto;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.domain.entities.Loan;
import com.substitutive.booksHub.domain.enums.LoanStatus;

import java.time.LocalDate;
import java.util.List;

/**
 * DTO de resposta para empréstimos.
 *
 * <p>Contém informações sobre o empréstimo, incluindo os livros emprestados,
 * o usuário que realizou o empréstimo, datas do empréstimo e devolução,
 * e o status do empréstimo.
 */
public record LoanResponseDto(
        Long id,
        List<BookResponseDto> books,
        UserResponseDto user,
        LocalDate loanDate,
        LocalDate dueDate,
        LocalDate returnDate,
        LoanStatus status
) {
    public static LoanResponseDto fromDomain(Loan loan) {
        return new LoanResponseDto(
                loan.getId(),
                loan.getBooks().stream().map(BookResponseDto::fromDomain).toList(),
                UserResponseDto.fromDomain(loan.getUser()),
                loan.getLoanDate(),
                loan.getDueDate(),
                loan.getReturnDate(),
                loan.getStatus()
        );
    }
}
