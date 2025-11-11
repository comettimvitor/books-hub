package com.substitutive.booksHub.infrastructure.persistence.mappers;

import com.substitutive.booksHub.domain.entities.Loan;
import com.substitutive.booksHub.infrastructure.persistence.entities.LoanEntity;

import java.util.stream.Collectors;

public class LoanMapper {
    public static LoanEntity toEntity(Loan loan) {
        LoanEntity entity = new LoanEntity();

        entity.setId(loan.getId());
        entity.setUserEntity(UserMapper.toEntity(loan.getUser()));
        entity.setLoanDate(loan.getLoanDate());
        entity.setDueDate(loan.getDueDate());
        entity.setReturnDate(loan.getReturnDate());
        entity.setStatus(loan.getStatus());

        entity.setBooks(
                loan.getBooks().stream()
                        .map(BookMapper::toEntity)
                        .collect(Collectors.toList())
        );

        return entity;
    }

    public static Loan toDomain(LoanEntity loanEntity) {
        return new Loan(
                loanEntity.getId(),
                loanEntity.getBooks().stream()
                        .map(BookMapper::toDomain)
                        .collect(Collectors.toList()),
                UserMapper.toDomain(loanEntity.getUserEntity()),
                loanEntity.getLoanDate(),
                loanEntity.getReturnDate(),
                loanEntity.getStatus()
        );
    }
}
