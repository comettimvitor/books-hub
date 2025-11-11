package com.substitutive.booksHub.infrastructure.persistence.mappers;

import com.substitutive.booksHub.domain.entities.Reservation;
import com.substitutive.booksHub.infrastructure.persistence.entities.ReservationEntity;

public class ReservationMapper {
    public static ReservationEntity toEntity(Reservation reservation) {
        return new ReservationEntity(
                reservation.getId(),
                UserMapper.toEntity(reservation.getUser()),
                BookMapper.toEntity(reservation.getBook()),
                reservation.getReservationDate()
        );
    }

    public static Reservation toDomain(ReservationEntity reservationEntity) {
        return new Reservation(
                UserMapper.toDomain(reservationEntity.getUserEntity()),
                BookMapper.toDomain(reservationEntity.getBookEntity())
        );
    }
}
