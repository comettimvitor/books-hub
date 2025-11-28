package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.entities.Loan;
import com.substitutive.booksHub.domain.enums.LoanStatus;
import com.substitutive.booksHub.domain.exceptions.LoanNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
/**
 * Caso de uso responsável por finalizar a devolução de um empréstimo.
 *
 * <p>Este caso de uso realiza as seguintes ações:
 * <ul>
 *     <li>Recupera todos os livros associados ao empréstimo informado;</li>
 *     <li>Marca cada livro como disponível e atualiza seu estado no repositório;</li>
 *     <li>Atualiza o status do empréstimo para devolvido, se estiver em andamento;</li>
 *     <li>Retorna um {@link LoanResponseDto} com as informações atualizadas do empréstimo.</li>
 * </ul>
 *
 * <p>Caso o empréstimo não seja encontrado, lança uma exceção {@link LoanNotFoundException}.
 */
@Service
@RequiredArgsConstructor
public class ReturnLoanUseCase {
    private final LoanDomainRepository loanDomainRepository;
    private final BookDomainRepository bookDomainRepository;

    @Transactional
    public LoanResponseDto execute(Long id) {
        List<Book> books = bookDomainRepository.findAllBooksByLoanId(id);
        books.forEach(book -> {
            book.endTransaction();
            bookDomainRepository.update(book.getId(), book);
        });

        Loan loan = loanDomainRepository.findById(id).orElseThrow(() -> new LoanNotFoundException("Loan not found."));
        if (LoanStatus.ON_GOING.equals(loan.getStatus())) {
            loan.returnBook();
        }

        Loan savedLoan = loanDomainRepository.returnLoan(loan);
        return LoanResponseDto.fromDomain(savedLoan);
    }
}
