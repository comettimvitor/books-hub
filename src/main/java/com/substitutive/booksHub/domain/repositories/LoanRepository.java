package com.substitutive.booksHub.domain.repositories;

import com.substitutive.booksHub.domain.entities.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanRepository {
    Loan loan(Loan loan);
    Optional<Loan> findById(Long id);
    List<Loan> findAll();
    List<Loan> findAllByUserId(Long userId);
    List<Loan> findAllByBookId(Long bookId);
    Loan update(Long id, Loan loan);
    void delete(Long id);
}
