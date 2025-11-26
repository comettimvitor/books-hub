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

@RestController
@RequestMapping("/reports")
@RequiredArgsConstructor
public class ReportsController {
    private final MostBorrowedBooksUseCase mostBorrowedBooksUseCase;
    private final BorrowedBooksUseCase borrowedBooksUseCase;

    @GetMapping("/most-borrowed-books")
    public ResponseEntity<List<MostBorrowedBooksResponseDto>> mostBorrowedBooks() {
        List<MostBorrowedBooksResponseDto> responseDto = mostBorrowedBooksUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/borrowed-books")
    public ResponseEntity<List<BorrowedBooksResponseDto>> borrowedBooks() {
        List<BorrowedBooksResponseDto> responseDto = borrowedBooksUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
