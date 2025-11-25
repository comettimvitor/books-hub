package com.substitutive.booksHub.infrastructure.persistence.adapters;

import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import com.substitutive.booksHub.infrastructure.persistence.mappers.BookMapper;
import com.substitutive.booksHub.infrastructure.persistence.repositories.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookJpaDomainRepositoryImpl implements BookDomainRepository {

    private final BookJpaRepository bookJpaRepository;

    @Override
    public Book save(Book book) {
        var bookEntity = BookMapper.toEntity(book);
        var savedBook = bookJpaRepository.save(bookEntity);
        return BookMapper.toDomain(savedBook);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookJpaRepository.findById(id).map(BookMapper::toDomain);
    }

    @Override
    public Optional<Book> findByBookTitle(String title) {
        return bookJpaRepository.findByTitle(title).map(BookMapper::toDomain);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookJpaRepository.findByAuthor(author).stream()
                .map(BookMapper::toDomain).toList();
    }

    @Override
    public List<Book> findAllByStatusAvailable() {
        return bookJpaRepository.findAllByStatusAvailable().stream()
                .map(BookMapper::toDomain).toList();
    }

    @Override
    public Optional<Book> findByIsbn(InternationalStandardBookNumber isbn) {
        return bookJpaRepository.findByIsbn(isbn.toString())
                .map(BookMapper::toDomain);
    }

    @Override
    public List<Book> findAll() {
        return bookJpaRepository.findAll().stream()
                .map(BookMapper::toDomain).toList();
    }

    @Override
    public List<Book> findAllById(Iterable<Long> ids) {
        return bookJpaRepository.findAllById(ids).stream().map(BookMapper::toDomain).toList();
    }

    @Override
    public List<Book> findAllBooksByLoanId(Long loanId) {
        return bookJpaRepository.findAllBooksByLoanId(loanId).stream().map(BookMapper::toDomain).toList();
    }

    @Override
    public Book update(Long id, Book book) {
        var entity = bookJpaRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found for update."));

        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setIsbn(book.getIsbn().toString());
        entity.setStatus(book.getStatus());
        entity.setAvailable(book.isAvailable());

        var saved = bookJpaRepository.save(entity);
        return BookMapper.toDomain(saved);
    }

    @Override
    public void delete(Long id) {
        bookJpaRepository.deleteById(id);
    }
}
