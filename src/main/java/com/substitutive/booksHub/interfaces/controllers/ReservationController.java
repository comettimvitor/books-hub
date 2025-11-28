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

/**
 * Controlador responsável pelo gerenciamento de reservas de livros.
 *
 * <p>Este controlador fornece endpoints para:
 * <ul>
 *   <li>Criar uma nova reserva;</li>
 *   <li>Listar reservas realizadas por um usuário;</li>
 *   <li>Listar reservas associadas a um livro;</li>
 *   <li>Encerrar uma reserva;</li>
 * </ul>
 *
 * <p>A lógica de negócio é delegada aos casos de uso correspondentes,
 * mantendo a separação de responsabilidades conforme a Clean Architecture.
 */
@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final CreateReservationUserCase createReservationUserCase;
    private final FindAllReservationsByUserUseCase findAllReservationsByUserUseCase;
    private final FindAllReservationsByBookUseCase findAllReservationsByBookUseCase;
    private final EndReservationUseCase endReservationUseCase;

    /**
     * Cria uma nova reserva de livro no sistema.
     *
     * @param request dados necessários para criação da reserva
     * @return objeto contendo os detalhes da reserva criada
     */
    @PostMapping("/create")
    public ResponseEntity<ReservationResponseDto> create(@RequestBody ReservationRequestDto request) {
        var response = createReservationUserCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Retorna todas as reservas associadas a um livro específico.
     *
     * @param id identificador do livro
     * @return lista de reservas vinculadas ao livro informado
     */
    @GetMapping("/by-book/{id}")
    public ResponseEntity<List<ReservationResponseDto>> findAllByBookId(@PathVariable("id") Long id) {
        List<ReservationResponseDto> dto = findAllReservationsByBookUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    /**
     * Retorna todas as reservas realizadas por um usuário específico.
     *
     * @param id identificador do usuário
     * @return lista de reservas realizadas pelo usuário informado
     */
    @GetMapping("/by-user/{id}")
    public ResponseEntity<List<ReservationResponseDto>> findAllByUserId(@PathVariable("id") Long id) {
        List<ReservationResponseDto> dto = findAllReservationsByUserUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    /**
     * Encerra uma reserva ativa.
     *
     * <p>Ao encerrar uma reserva, o livro reservado volta a ficar disponível.
     *
     * @param id identificador da reserva
     * @return dados do livro que teve sua reserva encerrada
     */
    @PutMapping("/end-reservation/reservation-id/{id}")
    public ResponseEntity<BookResponseDto> endReservation(@PathVariable("id") Long id) {
        BookResponseDto responseDto = endReservationUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
