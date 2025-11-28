package com.substitutive.booksHub.interfaces.controllers;

import com.substitutive.booksHub.application.dtos.bookdto.BookRequestDto;
import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.application.usecases.bookusecase.*;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável por gerenciar operações relacionadas aos livros.
 * Fornece endpoints para criação, consulta, atualização e deleção de livros.
 *
 * <p>Este controlador segue princípios de Clean Architecture,
 * delegando as regras de negócio para casos de uso específicos.</p>
 */
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
    private final FindAllBooksByLoanId findAllBooksByLoanId;
    private final UpdateBookUseCase updateBookUseCase;

    /**
     * Cria um novo livro no sistema.
     *
     * @param request dados necessários para criação de um livro
     * @return informações do livro criado
     */
    @PostMapping("/create")
    public ResponseEntity<BookResponseDto> create(@RequestBody BookRequestDto request) {
        BookRequestDto requestDto = request;
        BookResponseDto responseDto = createBookUseCase.execute(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    /**
     * Remove um livro pelo ID.
     *
     * @param id identificador do livro a ser removido
     * @return resposta sem conteúdo caso a remoção seja bem-sucedida
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        deleteBookUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Busca um livro pelo ID.
     *
     * @param id identificador do livro
     * @return informações do livro encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> findById(@PathVariable("id") Long id) {
        BookResponseDto responseDto = findBookByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Lista todos os livros que estão disponíveis.
     *
     * @return lista de livros disponíveis
     */
    @GetMapping("/availables")
    public ResponseEntity<List<BookResponseDto>> findAllBooksAvailable() {
        List<BookResponseDto> responseDto = findAllBooksByStatusAvailableUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Lista todos os livros cadastrados.
     *
     * @return lista completa de livros
     */
    @GetMapping()
    public ResponseEntity<List<BookResponseDto>> findAllBooks() {
        List<BookResponseDto> responseDto = findAllBooksUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Busca livros pelo nome do autor.
     *
     * @param author nome do autor
     * @return lista de livros correspondentes ao autor informado
     */
    @GetMapping("/author")
    public ResponseEntity<List<BookResponseDto>> findByAuthor(@RequestParam String author) {
        List<BookResponseDto> responseDto = findBookByAuthorUseCase.execute(author);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Busca um livro pelo ISBN.
     *
     * @param isbn valor do ISBN encapsulado no Value Object
     * @return livro correspondente ao ISBN informado
     */
    @GetMapping("/isbn")
    public ResponseEntity<BookResponseDto> findByIsbn(@RequestParam InternationalStandardBookNumber isbn) {
        BookResponseDto responseDto = findBookByIsbnUseCase.execute(isbn);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Busca um livro pelo título.
     *
     * @param title título do livro
     * @return livro correspondente ao título informado
     */
    @GetMapping("/title")
    public ResponseEntity<BookResponseDto> findByTitle(@RequestParam String title) {
        BookResponseDto responseDto = findBookByTitleUseCase.execute(title);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Lista todos os livros associados a um empréstimo específico.
     *
     * @param loanId identificador do empréstimo
     * @return lista de livros relacionados ao empréstimo
     */
    @GetMapping("/all-books/loan/{id}")
    public ResponseEntity<List<BookResponseDto>> findAllBooksByLoanId(@PathVariable("id") Long loanId) {
        List<BookResponseDto> responseDto = findAllBooksByLoanId.execute(loanId);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Atualiza as informações de um livro existente.
     *
     * @param id   identificador do livro
     * @param book entidade contendo os novos dados
     * @return informações atualizadas do livro
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<BookResponseDto> update(@PathVariable("id") Long id, @RequestBody Book book) {
        BookResponseDto responseDto = updateBookUseCase.execute(id, book);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
