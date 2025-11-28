package com.substitutive.booksHub.infrastructure.persistence.adapters;

import com.substitutive.booksHub.domain.entities.Reservation;
import com.substitutive.booksHub.domain.repositories.ReservationDomainRepository;
import com.substitutive.booksHub.infrastructure.persistence.mappers.ReservationMapper;
import com.substitutive.booksHub.infrastructure.persistence.repositories.ReservationJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Implementação do {@link ReservationDomainRepository} utilizando Spring Data JPA.
 * <p>
 * Atua como adaptador entre o domínio e a camada de persistência,
 * realizando a conversão entre objetos de domínio e entidades JPA
 * por meio do {@link ReservationMapper}.
 * </p>
 *
 * <p>
 * Responsável por salvar e consultar reservas de livros no banco de dados.
 * </p>
 */
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
