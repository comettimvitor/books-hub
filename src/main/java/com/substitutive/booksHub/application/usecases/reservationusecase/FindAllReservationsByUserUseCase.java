package com.substitutive.booksHub.application.usecases.reservationusecase;

import com.substitutive.booksHub.application.dtos.reservationdto.ReservationResponseDto;
import com.substitutive.booksHub.domain.repositories.ReservationDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso responsável por recuperar todas as reservas realizadas por um usuário específico.
 *
 * <p>Este caso de uso realiza as seguintes ações:
 * <ul>
 *     <li>Consulta todas as reservas relacionadas a um usuário pelo ID do usuário;</li>
 *     <li>Converte cada entidade de reserva em {@link ReservationResponseDto};</li>
 *     <li>Retorna a lista de reservas do usuário.</li>
 * </ul>
 */
@Service
@RequiredArgsConstructor
public class FindAllReservationsByUserUseCase {
    private final ReservationDomainRepository reservationDomainRepository;

    public List<ReservationResponseDto> execute(Long userId) {
        return reservationDomainRepository.findAllByUser(userId).stream().map(ReservationResponseDto::fromDomain).toList();
    }
}
