package com.substitutive.booksHub.infrastructure.persistence.adapters;

import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.models.BorrowedBooks;
import com.substitutive.booksHub.domain.models.MostBorrowedBook;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import com.substitutive.booksHub.infrastructure.persistence.mappers.BookMapper;
import com.substitutive.booksHub.infrastructure.persistence.repositories.BookJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Implementação da interface {@link BookDomainRepository} usando Spring Data JPA.
 *
 * <p>
 * Esta classe atua como um adaptador da camada de infraestrutura no contexto da
 * arquitetura hexagonal (ports & adapters). Seu papel é fazer a ponte entre
 * o domínio e a persistência, garantindo que entidades JPA sejam convertidas
 * para modelos de domínio e vice-versa.
 * </p>
 *
 * <p>
 * Todas as operações delegam o acesso ao banco de dados para {@link BookJpaRepository},
 * enquanto {@link BookMapper} realiza as conversões necessárias.
 * </p>
 *
 * <h2>Responsabilidades</h2>
 * <ul>
 *     <li>Persistir livros no banco de dados.</li>
 *     <li>Consultar livros por diferentes critérios (ID, título, autor, ISBN etc.).</li>
 *     <li>Atualizar dados de livros existentes.</li>
 *     <li>Excluir livros.</li>
 *     <li>Consultar estatísticas como livros mais emprestados.</li>
 *     <li>Integrar com projections de consultas complexas.</li>
 * </ul>
 *
 * <h2>Pontos de Atenção</h2>
 * <ul>
 *     <li>O método {@code update} lança {@link BookNotFoundException} caso o livro não exista.</li>
 *     <li>As conversões para e a partir do domínio são sempre realizadas em {@link BookMapper}.</li>
 *     <li>A validação de ISBN é garantida pelo value object {@link InternationalStandardBookNumber}.</li>
 * </ul>
 */
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
    public Optional<Book> findBookByReservationId(Long reservationId) {
        return bookJpaRepository.findBookByReservationId(reservationId).map(BookMapper::toDomain);
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

    @Override
    public List<MostBorrowedBook> mostBorrowedBooks() {
        return bookJpaRepository.mostBorrowedBooks()
                .stream()
                .map(projection -> new MostBorrowedBook(
                                projection.getId(),
                                projection.getTitle(),
                                projection.getAuthor(),
                                projection.getIsbn(),
                                projection.getTotalLoans()
                        )
                )
                .toList();
    }

    @Override
    public List<BorrowedBooks> borrowedBooks() {
        return bookJpaRepository.borrowedBooks()
                .stream()
                .map(projection -> new BorrowedBooks(
                                projection.getId(),
                                projection.getTitle(),
                                projection.getAuthor(),
                                projection.getIsbn(),
                                projection.getDueDate()
                        )
                )
                .toList();
    }
}
