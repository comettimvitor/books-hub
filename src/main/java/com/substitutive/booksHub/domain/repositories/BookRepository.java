package com.substitutive.booksHub.domain.repositories;

import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Book save(Book book);
    Optional<Book> findById(Long id);
    Optional<Book> findByBookTitle(String title);
    List<Book> findByAuthor(String author);
    List<Book> findAllByStatusAvailable();
    Optional<Book> findByIsbn(InternationalStandardBookNumber isbn);
    List<Book> findAll();
    Book update(Long id, Book book);
    void delete(Long id);
}
