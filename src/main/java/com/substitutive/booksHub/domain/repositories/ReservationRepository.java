package com.substitutive.booksHub.domain.repositories;

import com.substitutive.booksHub.domain.entities.Reservation;

import java.util.List;

public interface ReservationRepository {
    Reservation reservation(Reservation reservation);
    List<Reservation> findAllByUser(Long userId);
    List<Reservation> findAllByBook(Long bookId);
}
