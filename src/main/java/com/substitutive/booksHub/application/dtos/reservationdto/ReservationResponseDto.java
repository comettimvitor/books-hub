package com.substitutive.booksHub.application.dtos.reservationdto;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.domain.entities.Reservation;

import java.time.LocalDate;
/**
 * DTO de resposta para uma reserva de livro.
 *
 * <p>Contém informações sobre a reserva, o usuário que a realizou,
 * o livro reservado e a data da reserva.
 */
public record ReservationResponseDto(
        Long id,
        UserResponseDto user,
        BookResponseDto book,
        LocalDate reservationDate
) {
    public static ReservationResponseDto fromDomain(Reservation reservation) {
        return new ReservationResponseDto(
                reservation.getId(),
                UserResponseDto.fromDomain(reservation.getUser()),
                BookResponseDto.fromDomain(reservation.getBook()),
                reservation.getReservationDate()
        );
    }
}
