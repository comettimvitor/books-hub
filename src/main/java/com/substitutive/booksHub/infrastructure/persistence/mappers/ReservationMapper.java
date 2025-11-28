package com.substitutive.booksHub.infrastructure.persistence.mappers;

import com.substitutive.booksHub.domain.entities.Reservation;
import com.substitutive.booksHub.infrastructure.persistence.entities.ReservationEntity;
/**
 * Classe responsável por realizar a conversão entre o objeto de domínio {@link Reservation}
 * e a entidade {@link ReservationEntity} utilizada pelo JPA.
 *
 * <p>Este mapper garante que os dados das reservas sejam corretamente
 * traduzidos entre a camada de domínio e a camada de persistência.</p>
 *
 * <p>Principais operações:</p>
 * <ul>
 *     <li>Converter {@link Reservation} em {@link ReservationEntity};</li>
 *     <li>Converter {@link ReservationEntity} em {@link Reservation};</li>
 *     <li>Mapear o usuário associado à reserva;</li>
 *     <li>Mapear o livro reservado.</li>
 * </ul>
 */
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
                reservationEntity.getId(),
                UserMapper.toDomain(reservationEntity.getUserEntity()),
                BookMapper.toDomain(reservationEntity.getBookEntity()),
                reservationEntity.getReservationDate()
        );
    }
}
