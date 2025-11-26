package com.substitutive.booksHub.infrastructure.persistence.adapters;

import com.substitutive.booksHub.domain.entities.Reservation;
import com.substitutive.booksHub.domain.repositories.ReservationDomainRepository;
import com.substitutive.booksHub.infrastructure.persistence.mappers.ReservationMapper;
import com.substitutive.booksHub.infrastructure.persistence.repositories.ReservationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationJpaDomainRepositoryImpl implements ReservationDomainRepository {

    private final ReservationJpaRepository reservationJpaRepository;

    @Override
    public Reservation save(Reservation reservation) {
        var reservationEntity = ReservationMapper.toEntity(reservation);
        var savedReservation = reservationJpaRepository.save(reservationEntity);
        return ReservationMapper.toDomain(savedReservation);
    }

    @Override
    public List<Reservation> findAllByUser(Long userId) {
        return reservationJpaRepository.findAllByUserEntity_Id(userId).stream().map(ReservationMapper::toDomain).toList();
    }

    @Override
    public List<Reservation> findAllByBookEntity_Id(Long bookId) {
        return reservationJpaRepository.findAllByBookEntity_Id(bookId).stream().map(ReservationMapper::toDomain).toList();
    }
}
