package com.substitutive.booksHub.infrastructure.persistence.repositories;

import com.substitutive.booksHub.infrastructure.persistence.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * Repositório JPA responsável pelas operações de persistência da entidade {@link ReservationEntity}.
 * <p>
 * Fornece métodos para consultar reservas com base no usuário ou no livro,
 * utilizando convenções de nomes do Spring Data JPA.
 */
public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findAllByUserEntity_Id(Long userId);
    List<ReservationEntity> findAllByBookEntity_Id(Long bookId);
}
