package com.substitutive.booksHub.infrastructure.persistence.repositories;

import com.substitutive.booksHub.infrastructure.persistence.entities.BookEntity;
import com.substitutive.booksHub.infrastructure.persistence.projections.BorrowedBooksProjection;
import com.substitutive.booksHub.infrastructure.persistence.projections.MostBorrowedBookProjection;
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
            WHERE lb.loan_id = :loanId;
            """,
            nativeQuery = true)
    List<BookEntity> findAllBooksByLoanId(Long loanId);

    @Query(value = """
            SELECT b.* FROM reservations r
            JOIN books b ON b.id = r.book_id
            WHERE r.id = :reservationId;
            """,
            nativeQuery = true)
    Optional<BookEntity> findBookByReservationId(Long reservationId);

    @Query(value = "SELECT b.* FROM books b WHERE b.is_available = true;", nativeQuery = true)
    List<BookEntity> findAllByStatusAvailable();

    @Query(value = """
            SELECT b.id, b.title, b.author, b.isbn, COUNT(lb.loan_id) AS total_loans
            FROM books b
            JOIN loan_books lb ON lb.book_id = b.id
            GROUP BY b.id, b.title, b.author, b.isbn
            ORDER BY total_loans DESC
            LIMIT 20;
            """,
            nativeQuery = true)
    List<MostBorrowedBookProjection> mostBorrowedBooks();

    @Query(value = """
            SELECT b.id, b.title, b.author, b.isbn, l.due_date
            FROM books b
            JOIN loan_books lb ON lb.book_id = b.id
            JOIN loans l ON l.id = lb.loan_id
            WHERE b.is_available = false
                AND b.status = 'BORROWED'
                AND l.return_date is null
                AND l.status = 'ON_GOING';
            """,
            nativeQuery = true)
    List<BorrowedBooksProjection> borrowedBooks();
}
