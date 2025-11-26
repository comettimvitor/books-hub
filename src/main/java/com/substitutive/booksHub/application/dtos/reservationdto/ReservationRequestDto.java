package com.substitutive.booksHub.application.dtos.reservationdto;

public record ReservationRequestDto(
        Long userId,
        Long bookId
) {}
