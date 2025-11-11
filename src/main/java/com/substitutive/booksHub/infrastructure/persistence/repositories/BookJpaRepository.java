package com.substitutive.booksHub.infrastructure.persistence.repositories;

import com.substitutive.booksHub.infrastructure.persistence.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookJpaRepository extends JpaRepository<BookEntity, Long> {
    Optional<BookEntity> findByTitle(String title);
    List<BookEntity> findByAuthor(String author);
    Optional<BookEntity> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);

    @Query(value = "SELECT b.* FROM books b WHERE b.is_available = true", nativeQuery = true)
    List<BookEntity> findAllByStatusAvailable();
}
