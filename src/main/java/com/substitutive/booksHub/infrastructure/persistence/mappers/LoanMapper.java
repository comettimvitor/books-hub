package com.substitutive.booksHub.infrastructure.persistence.mappers;

import com.substitutive.booksHub.domain.entities.Loan;
import com.substitutive.booksHub.infrastructure.persistence.entities.LoanEntity;

import java.util.stream.Collectors;
/**
 * Classe responsável por converter objetos entre o domínio {@link Loan}
 * e a entidade {@link LoanEntity} utilizada pelo JPA.
 *
 * <p>Este mapper cuida da transformação dos dados de empréstimos,
 * preservando as regras de negócio do domínio e preparando os dados
 * para persistência.</p>
 *
 * <p>Operações realizadas:</p>
 * <ul>
 *     <li>Conversão de {@link Loan} para {@link LoanEntity};</li>
 *     <li>Conversão de {@link LoanEntity} para {@link Loan};</li>
 *     <li>Mapeamento de listas de livros associados ao empréstimo;</li>
 *     <li>Conversão do usuário responsável pelo empréstimo.</li>
 * </ul>
 */
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
                loanEntity.getReturnDate()
        );
    }
}
