package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.application.dtos.loandto.LoanRequestDto;
import com.substitutive.booksHub.application.dtos.loandto.LoanResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.entities.Loan;
import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.enums.LoanStatus;
import com.substitutive.booksHub.domain.exceptions.BookNotAvailableException;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.exceptions.UserNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * Caso de uso responsável por criar um novo empréstimo de livros para um usuário.
 *
 * <p>Valida se o usuário existe e se os livros selecionados estão disponíveis.
 * Se algum livro não estiver disponível, lança {@link BookNotAvailableException}.
 * Se nenhum livro for encontrado, lança {@link BookNotFoundException}.
 * Se o usuário não existir, lança {@link UserNotFoundException}.
 */
@Service
@RequiredArgsConstructor
public class CreateLoanUseCase {
    private final LoanDomainRepository loanDomainRepository;
    private final UserDomainRepository userDomainRepository;
    private final BookDomainRepository bookDomainRepository;

    @Transactional
    public LoanResponseDto execute(LoanRequestDto request) {
        User user = userDomainRepository.findById(request.userId()).orElseThrow(() -> new UserNotFoundException("User not found."));
        List<Book> books = bookDomainRepository.findAllById(request.bookIds());

        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found");
        }

        books.forEach(book -> {
            if (!book.isAvailable()) {
                throw new BookNotAvailableException(
                        "Book is not available."
                );
            }
        });

        books.forEach(book -> {
            book.loan();
            bookDomainRepository.save(book);
        });

        Loan loan = new Loan(books, user);
        Loan savedLoan = loanDomainRepository.save(loan);
        return LoanResponseDto.fromDomain(savedLoan);
    }
}
