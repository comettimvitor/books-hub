package com.substitutive.booksHub.interfaces.controllers;

import com.substitutive.booksHub.application.dtos.loandto.LoanRequestDto;
import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.application.usecases.loanusecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador responsável por gerenciar operações relacionadas a empréstimos (Loans).
 *
 * <p>Este controlador expõe endpoints REST para criação, listagem, consulta,
 * exclusão e devolução de empréstimos. As regras de negócio são delegadas
 * para casos de uso específicos seguindo princípios de Clean Architecture.</p>
 */
@RestController
@RequestMapping("/loans")
@RequiredArgsConstructor
public class LoanController {
    private final CreateLoanUseCase createLoanUseCase;
    private final DeleteLoanUseCase deleteLoanUseCase;
    private final FindAllLoansByBookUseCase findAllLoansByBookUseCase;
    private final FindAllLoansByUserUseCase findAllLoansByUserUseCase;
    private final FindAllLoansUseCase findAllLoansUseCase;
    private final FindLoanByIdUseCase findLoanByIdUseCase;
    private final ReturnLoanUseCase returnLoanUseCase;

    /**
     * Cria um novo empréstimo no sistema.
     *
     * @param request informações necessárias para criação de um empréstimo
     * @return dados do empréstimo criado
     */
    @PostMapping("/create")
    public ResponseEntity<LoanResponseDto> create(@RequestBody LoanRequestDto request) {
        var responseDto = createLoanUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    /**
     * Remove um empréstimo do sistema pelo ID.
     *
     * @param id identificador do empréstimo
     * @return resposta sem conteúdo em caso de sucesso
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        deleteLoanUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Lista todos os empréstimos associados a um livro específico.
     *
     * @param id identificador do livro
     * @return lista de empréstimos relacionados ao livro
     */
    @GetMapping("/by-book/{id}")
    public ResponseEntity<List<LoanResponseDto>> findAllLoansByBookId(@PathVariable("id") Long id) {
        List<LoanResponseDto> loanResponseDtos = findAllLoansByBookUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(loanResponseDtos);
    }

    /**
     * Lista todos os empréstimos realizados por um determinado usuário.
     *
     * @param id identificador do usuário
     * @return lista de empréstimos associados ao usuário
     */
    @GetMapping("/by-user/{id}")
    public ResponseEntity<List<LoanResponseDto>> findAllLoansByUserId(@PathVariable("id") Long id) {
        List<LoanResponseDto> loanResponseDtos = findAllLoansByUserUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(loanResponseDtos);
    }

    /**
     * Lista todos os empréstimos cadastrados no sistema.
     *
     * @return lista completa de empréstimos
     */
    @GetMapping()
    public ResponseEntity<List<LoanResponseDto>> findAllLoans() {
        List<LoanResponseDto> loanResponseDtos = findAllLoansUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(loanResponseDtos);
    }

    /**
     * Busca um empréstimo pelo ID.
     *
     * @param id identificador do empréstimo
     * @return informações do empréstimo encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDto> findById(@PathVariable("id") Long id) {
        LoanResponseDto responseDto = findLoanByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Realiza a devolução de um empréstimo.
     *
     * @param id identificador do empréstimo a ser devolvido
     * @return informações atualizadas do empréstimo após a devolução
     */
    @PutMapping("/return/{id}")
    public ResponseEntity<LoanResponseDto> update(@PathVariable("id") Long id) {
        LoanResponseDto dto = returnLoanUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
