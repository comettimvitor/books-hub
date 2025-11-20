package com.substitutive.booksHub.infrastructure.dtos;

import java.time.Instant;

public record ErrorResponse(
        String message,
        String error,
        int status,
        Instant timestamp
)  {
}
