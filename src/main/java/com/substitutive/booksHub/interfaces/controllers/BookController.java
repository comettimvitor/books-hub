package com.substitutive.booksHub.interfaces.controllers;

import com.substitutive.booksHub.application.dtos.bookdto.BookRequestDto;
import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.application.usecases.bookusecase.*;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import com.substitutive.booksHub.interfaces.requests.CreateBookRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final CreateBookUseCase createBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;
    private final FindBookByIdUseCase findBookByIdUseCase;
    private final FindAllBooksByStatusAvailableUseCase findAllBooksByStatusAvailableUseCase;
    private final FindAllBooksUseCase findAllBooksUseCase;
    private final FindBookByAuthorUseCase findBookByAuthorUseCase;
    private final FindBookByIsbnUseCase findBookByIsbnUseCase;
    private final FindBookByTitleUseCase findBookByTitleUseCase;
    private final UpdateBookUseCase updateBookUseCase;

    @PostMapping("/create")
    public ResponseEntity<BookResponseDto> create(@RequestBody CreateBookRequest request) {
        BookRequestDto requestDto = request.toDTO();
        BookResponseDto responseDto = createBookUseCase.execute(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@RequestParam("id") Long id) {
        deleteBookUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> findById(@RequestParam("id") Long id) {
        BookResponseDto responseDto = findBookByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/availables")
    public ResponseEntity<List<BookResponseDto>> findAllBooksAvailable() {
        List<BookResponseDto> responseDto = findAllBooksByStatusAvailableUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping()
    public ResponseEntity<List<BookResponseDto>> findAllBooks() {
        List<BookResponseDto> responseDto = findAllBooksUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/author")
    public ResponseEntity<List<BookResponseDto>> findByAuthor(@RequestBody String author) {
        List<BookResponseDto> responseDto = findBookByAuthorUseCase.execute(author);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/isbn")
    public ResponseEntity<BookResponseDto> findByIsbn(@RequestBody InternationalStandardBookNumber isbn) {
        BookResponseDto responseDto = findBookByIsbnUseCase.execute(isbn);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/title")
    public ResponseEntity<BookResponseDto> findByTitle(@RequestBody String title) {
        BookResponseDto responseDto = findBookByTitleUseCase.execute(title);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BookResponseDto> update(@RequestParam("id") Long id, @RequestBody Book book) {
        BookResponseDto responseDto = updateBookUseCase.execute(id, book);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
