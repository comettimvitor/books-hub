package com.substitutive.booksHub.application.dtos.reservationdto;

import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.entities.Reservation;
import com.substitutive.booksHub.domain.entities.User;

import java.time.LocalDate;

public record ReservationRequestDto(
        User user,
        Book book,
        LocalDate localDate
) {
    public Reservation toDomain() {
        return new Reservation(user, book);
    }
}
