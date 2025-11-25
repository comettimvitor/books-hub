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

    @Query(value = """
            SELECT b.* FROM loan_books lb
            JOIN books b ON b.id = lb.book_id
            WHERE lb.loan_id = :loanId
            """,
            nativeQuery = true)
    List<BookEntity> findAllBooksByLoanId(Long loanId);

    @Query(value = "SELECT b.* FROM books b WHERE b.is_available = true", nativeQuery = true)
    List<BookEntity> findAllByStatusAvailable();
}
