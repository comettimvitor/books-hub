package com.substitutive.booksHub.infrastructure.persistence.repositories;

import com.substitutive.booksHub.infrastructure.persistence.entities.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findAllByUserEntity_Id(Long userId);
    List<ReservationEntity> findAllByBookEntity_Id(Long bookId);
}
