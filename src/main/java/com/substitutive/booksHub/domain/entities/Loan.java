package com.substitutive.booksHub.domain.entities;

import com.substitutive.booksHub.domain.enums.LoanStatus;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.exceptions.UserNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Representa um emprestimo de um livro no sistema Book Hub.
 * Contém informações principais como a lista de livros emprestados, a data do emprestimo, data de vencimento do emprestimo
 * e data de retorno dos livros.
 * <p>
 * Esta classe é usada em operações de cadastro, listagem,
 * atualização e retorno de emprestimos.
 */

public class Loan {

    private Long id;
    private List<Book> books;
    private User user;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private LoanStatus status;

    private static final int LOAN_PERIOD_DAYS = 7;

    public Loan(Long id, List<Book> book, User user, LocalDate loanDate, LocalDate returnDate) {
        if (user == null) throw new UserNotFoundException("User must be informed.");
        if (book == null) throw new BookNotFoundException("Book must be informed.");
        if (loanDate == null) throw new IllegalArgumentException("Loan Date must be informed.");

        this.id = id;
        this.books = book;
        this.user = user;
        this.loanDate = loanDate;
        this.dueDate = loanDate.plusDays(LOAN_PERIOD_DAYS);
        this.returnDate = returnDate;
        this.status = LoanStatus.ON_GOING;
    }

    public Loan(List<Book> books, User user) {
        this.books = books;
        this.user = user;
        this.loanDate = LocalDate.now();
        this.dueDate = loanDate.plusDays(LOAN_PERIOD_DAYS);
        this.status = LoanStatus.ON_GOING;
    }

    public Long getId() {
        return id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }

    /**
     * Metodo para marcar data de retorno de livros devolvidos e status do emprestimo.
     */
    public void returnBook() {
        this.returnDate = LocalDate.now();
        this.status = returnDate.isAfter(dueDate) ? LoanStatus.LATE : LoanStatus.RETURNED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        Loan loan = (Loan) o;
        return Objects.equals(id, loan.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
