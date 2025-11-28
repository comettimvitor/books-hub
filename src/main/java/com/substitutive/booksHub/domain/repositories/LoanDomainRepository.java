package com.substitutive.booksHub.domain.repositories;

import com.substitutive.booksHub.domain.entities.Loan;

import java.util.List;
import java.util.Optional;
/**
 * Repositório de domínio responsável por operações relacionadas à entidade {@link Loan}.
 *
 * <p>
 * Define os contratos essenciais para persistência, consulta e operações
 * específicas sobre empréstimos dentro do contexto do sistema BookHub.
 * Segue os princípios de DDD, mantendo o domínio desacoplado dos detalhes de infraestrutura.
 * </p>
 */
public interface LoanDomainRepository {
    Loan save(Loan loan);

    Optional<Loan> findById(Long id);

    List<Loan> findAll();

    List<Loan> findAllByUserId(Long userId);

    List<Loan> findAllByBookId(Long bookId);

    Loan returnLoan(Loan loan);

    void delete(Long id);
}
