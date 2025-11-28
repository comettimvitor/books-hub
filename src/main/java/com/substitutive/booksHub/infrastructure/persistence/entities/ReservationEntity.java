package com.substitutive.booksHub.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
/**
 * Representa uma reserva de livro feita por um usuário no sistema.
 *
 * <p>Esta entidade é mapeada para a tabela {@code reservations} e contém:
 * <ul>
 *     <li>O usuário que realizou a reserva ({@link UserEntity});</li>
 *     <li>O livro reservado ({@link BookEntity});</li>
 *     <li>A data em que a reserva foi efetuada.</li>
 * </ul>
 *
 * <p>Cada livro só pode ter uma reserva ativa por vez, sendo refletido pela
 * restrição {@code unique = true} na coluna {@code book_id}.
 */
@Entity
@Table(name = "reservations")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "book_id", unique = true, nullable = false)
    private BookEntity bookEntity;
    private LocalDate reservationDate;
}
