package com.substitutive.booksHub.interfaces.controllers;

import com.substitutive.booksHub.application.dtos.bookdto.BorrowedBooksResponseDto;
import com.substitutive.booksHub.application.dtos.bookdto.MostBorrowedBooksResponseDto;
import com.substitutive.booksHub.application.usecases.bookusecase.BorrowedBooksUseCase;
import com.substitutive.booksHub.application.usecases.bookusecase.MostBorrowedBooksUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador responsável por fornecer relatórios relacionados aos livros.
 *
 * <p>Este controlador disponibiliza endpoints para consultar:
 * <ul>
 *   <li>Os livros mais emprestados;</li>
 *   <li>Os livros atualmente emprestados;</li>
 * </ul>
 * <p>
 * A lógica de negócio é delegada aos casos de uso apropriados,
 * seguindo os princípios da Clean Architecture.
 */
@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportsController {
    private final MostBorrowedBooksUseCase mostBorrowedBooksUseCase;
    private final BorrowedBooksUseCase borrowedBooksUseCase;

    /**
     * Obtém a lista dos livros mais emprestados do sistema.
     *
     * @return lista contendo informações sobre os livros mais emprestados
     */
    @GetMapping("/most-borrowed-books")
    public ResponseEntity<List<MostBorrowedBooksResponseDto>> mostBorrowedBooks() {
        List<MostBorrowedBooksResponseDto> responseDto = mostBorrowedBooksUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Obtém a lista de todos os livros que estão atualmente emprestados.
     *
     * @return lista contendo informações sobre os livros emprestados
     */
    @GetMapping("/borrowed-books")
    public ResponseEntity<List<BorrowedBooksResponseDto>> borrowedBooks() {
        List<BorrowedBooksResponseDto> responseDto = borrowedBooksUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
