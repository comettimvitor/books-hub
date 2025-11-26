package com.substitutive.booksHub.domain.repositories;

import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.models.BorrowedBooks;
import com.substitutive.booksHub.domain.models.MostBorrowedBook;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;

import java.util.List;
import java.util.Optional;

public interface BookDomainRepository {
    Book save(Book book);

    Optional<Book> findById(Long id);

    Optional<Book> findByBookTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findAllByStatusAvailable();

    Optional<Book> findByIsbn(InternationalStandardBookNumber isbn);

    List<Book> findAll();

    List<Book> findAllById(Iterable<Long> ids);

    List<Book> findAllBooksByLoanId(Long loanId);

    Optional<Book> findBookByReservationId(Long loanId);

    Book update(Long id, Book book);

    void delete(Long id);

    List<MostBorrowedBook> mostBorrowedBooks();

    List<BorrowedBooks> borrowedBooks();
}
