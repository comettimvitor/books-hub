package com.substitutive.booksHub.application.usecases.reservationusecase;

import com.substitutive.booksHub.application.dtos.reservationdto.ReservationResponseDto;
import com.substitutive.booksHub.domain.repositories.ReservationDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllReservationsByUserUseCase {
    private final ReservationDomainRepository reservationDomainRepository;

    public List<ReservationResponseDto> execute(Long userId) {
        return reservationDomainRepository.findAllByUser(userId).stream().map(ReservationResponseDto::fromDomain).toList();
    }
}
