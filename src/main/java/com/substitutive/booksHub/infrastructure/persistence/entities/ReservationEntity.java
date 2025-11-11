package com.substitutive.booksHub.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @OneToOne
    @JoinColumn(name = "book_id", unique = true, nullable = false)
    private BookEntity bookEntity;
    private LocalDate reservationDate;
}
