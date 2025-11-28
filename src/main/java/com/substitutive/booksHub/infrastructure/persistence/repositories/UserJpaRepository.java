package com.substitutive.booksHub.infrastructure.persistence.repositories;

import com.substitutive.booksHub.domain.valueobjects.CPF;
import com.substitutive.booksHub.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositório JPA responsável pelas operações de persistência da entidade {@link UserEntity}.
 * <p>
 * Fornece métodos adicionais de consulta utilizando convenções do Spring Data JPA.
 */
public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findUserByName(String name);

    boolean existsByCpf(CPF cpf);
}
