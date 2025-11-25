package com.substitutive.booksHub.infrastructure.adapters;

import com.substitutive.booksHub.domain.exceptions.DomainException;
import com.substitutive.booksHub.infrastructure.dtos.ErrorResponse;
import org.hibernate.TransientObjectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleDomain(RuntimeException ex) {

        if (ex instanceof DomainException domainException) {
            int status = domainException.getHttpStatus();

            return ResponseEntity
                    .status(status)
                    .body(new ErrorResponse(
                            ex.getMessage(),
                            ex.getClass().getSimpleName(),
                            status,
                            Instant.now()
                    ));
        }

        throw ex;
    }
}
