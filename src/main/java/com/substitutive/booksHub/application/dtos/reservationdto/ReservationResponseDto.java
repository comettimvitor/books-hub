package com.substitutive.booksHub.application.dtos.reservationdto;

import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.entities.Reservation;
import com.substitutive.booksHub.domain.entities.User;

import java.time.LocalDate;

public record ReservationResponseDto(
        Long id,
        User user,
        Book book,
        LocalDate reservationDate
) {
    public static ReservationResponseDto fromDomain(Reservation reservation) {
        return new ReservationResponseDto(
                reservation.getId(),
                reservation.getUser(),
                reservation.getBook(),
                reservation.getReservationDate()
        );
    }
}
