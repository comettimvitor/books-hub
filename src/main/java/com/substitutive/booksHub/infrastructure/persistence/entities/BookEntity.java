package com.substitutive.booksHub.infrastructure.persistence.entities;

import com.substitutive.booksHub.domain.enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;
/**
 * Representação da entidade JPA que mapeia os livros armazenados no banco de dados.
 * <p>
 * Esta classe corresponde à tabela {@code books} e contém as informações básicas
 * de um livro, incluindo título, autor, ISBN, status e disponibilidade.
 * </p>
 *
 * <p>
 * Também mantém o relacionamento de associação com {@link ReservationEntity},
 * indicando uma reserva vinculada ao livro (quando existir).
 * </p>
 */
@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String isbn;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    private boolean isAvailable;

    @OneToOne(mappedBy = "bookEntity")
    private ReservationEntity reservation;

    public BookEntity(Long id, String title, String author, String isbn, BookStatus status, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = status;
        this.isAvailable = available;
    }
}
