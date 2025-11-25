package com.substitutive.booksHub.interfaces.controllers;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.application.dtos.reservationdto.ReservationRequestDto;
import com.substitutive.booksHub.application.dtos.reservationdto.ReservationResponseDto;
import com.substitutive.booksHub.application.usecases.reservationusecase.CreateReservationUserCase;
import com.substitutive.booksHub.application.usecases.reservationusecase.EndReservationUseCase;
import com.substitutive.booksHub.application.usecases.reservationusecase.FindAllReservationsByBookUseCase;
import com.substitutive.booksHub.application.usecases.reservationusecase.FindAllReservationsByUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final CreateReservationUserCase createReservationUserCase;
    private final FindAllReservationsByUserUseCase findAllReservationsByUserUseCase;
    private final FindAllReservationsByBookUseCase findAllReservationsByBookUseCase;
    private final EndReservationUseCase endReservationUseCase;

    @PostMapping("/create")
    public ResponseEntity<ReservationResponseDto> create(@RequestBody ReservationRequestDto request) {
        var response = createReservationUserCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/by-book/{id}")
    public ResponseEntity<List<ReservationResponseDto>> findAllByBookId(@PathVariable("id") Long id) {
        List<ReservationResponseDto> dto = findAllReservationsByBookUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @GetMapping("/by-user/{id}")
    public ResponseEntity<List<ReservationResponseDto>> findAllByUserId(@PathVariable("id") Long id) {
        List<ReservationResponseDto> dto = findAllReservationsByUserUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PutMapping("/end-reservation/reservation-id/{id}")
    public ResponseEntity<BookResponseDto> endReservation(@PathVariable("id") Long id) {
        BookResponseDto responseDto = endReservationUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
