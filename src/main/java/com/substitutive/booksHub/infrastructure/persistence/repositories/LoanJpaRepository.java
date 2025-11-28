package com.substitutive.booksHub.infrastructure.persistence.repositories;

import com.substitutive.booksHub.infrastructure.persistence.entities.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Repositório JPA responsável pelas operações de persistência da entidade {@link LoanEntity}.
 * <p>
 * Utiliza consultas derivadas do Spring Data para buscar empréstimos por usuário ou por livro,
 * facilitando o acesso a informações importantes do fluxo de empréstimos.
 */
public interface LoanJpaRepository extends JpaRepository<LoanEntity, Long> {
    List<LoanEntity> findAllByUserEntity_Id(Long userId);
    List<LoanEntity> findAllByBooks_Id(Long bookId);
}
