package com.substitutive.booksHub.application.dtos.reservationdto;
/**
 * DTO de requisição para criar uma reserva de livro.
 *
 * <p>Contém o identificador do usuário que deseja realizar a reserva
 * e o identificador do livro a ser reservado.
 */
public record ReservationRequestDto(
        Long userId,
        Long bookId
) {}
