package com.substitutive.booksHub.application.dtos.reservationdto;

import java.time.LocalDate;

public record ReservationRequestDto(
        Long userId,
        Long bookId,
        LocalDate localDate
) {}
