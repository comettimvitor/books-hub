package com.substitutive.booksHub.application.usecases.reservationusecase;

import com.substitutive.booksHub.application.dtos.reservationdto.ReservationRequestDto;
import com.substitutive.booksHub.application.dtos.reservationdto.ReservationResponseDto;
import com.substitutive.booksHub.domain.entities.Reservation;
import com.substitutive.booksHub.domain.repositories.ReservationDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateReservationUserCase {
    private final ReservationDomainRepository reservationDomainRepository;

    @Transactional
    public ReservationResponseDto execute(ReservationRequestDto requestDto) {
        Reservation reservation = requestDto.toDomain();
        Reservation saved = reservationDomainRepository.save(reservation);
        return ReservationResponseDto.fromDomain(saved);
    }
}
