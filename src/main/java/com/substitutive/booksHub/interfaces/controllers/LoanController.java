package com.substitutive.booksHub.interfaces.controllers;

import com.substitutive.booksHub.application.dtos.loandto.LoanRequestDto;
import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.application.usecases.loanusecase.*;
import com.substitutive.booksHub.domain.entities.Loan;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private final UpdateLoanUseCase updateLoanUseCase;

    @PostMapping("/create")
    public ResponseEntity<LoanResponseDto> create(@RequestBody LoanRequestDto request) {
        var responseDto = createLoanUseCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        deleteLoanUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/by-book/{id}")
    public ResponseEntity<List<LoanResponseDto>> findAllLoansByBookId(@PathVariable("id") Long id) {
        List<LoanResponseDto> loanResponseDtos = findAllLoansByBookUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(loanResponseDtos);
    }

    @GetMapping("/by-user/{id}")
    public ResponseEntity<List<LoanResponseDto>> findAllLoansByUserId(@PathVariable("id") Long id) {
        List<LoanResponseDto> loanResponseDtos = findAllLoansByUserUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(loanResponseDtos);
    }

    @GetMapping()
    public ResponseEntity<List<LoanResponseDto>> findAllLoans() {
        List<LoanResponseDto> loanResponseDtos = findAllLoansUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(loanResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDto> findById(@PathVariable("id") Long id) {
        LoanResponseDto responseDto = findLoanByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<LoanResponseDto> update(@PathVariable("id") Long id, @RequestBody Loan loan) {
        LoanResponseDto dto = updateLoanUseCase.execute(id, loan);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

}
