package com.substitutive.booksHub.infrastructure.persistence.repositories;

import com.substitutive.booksHub.infrastructure.persistence.entities.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanJpaRepository extends JpaRepository<LoanEntity, Long> {
    List<LoanEntity> findAllByUserEntity_Id(Long userId);
    List<LoanEntity> findAllByBooks_Id(Long bookId);
}
