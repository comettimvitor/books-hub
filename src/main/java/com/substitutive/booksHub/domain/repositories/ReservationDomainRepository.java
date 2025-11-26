package com.substitutive.booksHub.domain.repositories;

import com.substitutive.booksHub.domain.entities.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationDomainRepository {
    Reservation save(Reservation reservation);
    List<Reservation> findAllByUser(Long userId);
    List<Reservation> findAllByBookEntity_Id(Long bookId);
}
