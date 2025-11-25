package com.substitutive.booksHub.domain.repositories;

import com.substitutive.booksHub.domain.entities.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanDomainRepository {
    Loan save(Loan loan);
    Optional<Loan> findById(Long id);
    List<Loan> findAll();
    List<Loan> findAllByUserId(Long userId);
    List<Loan> findAllByBookId(Long bookId);
    Loan returnLoan(Loan loan);
    void delete(Long id);
}
