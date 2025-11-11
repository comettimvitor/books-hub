package com.substitutive.booksHub.domain.entities;

import com.substitutive.booksHub.domain.enums.LoanStatus;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.exceptions.UserNotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Loan {

    private Long id;
    private List<Book> books;
    private User user;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private LoanStatus status;

    private static final int LOAN_PERIOD_DAYS = 7;

    public Loan(Long id, List<Book> book, User user, LocalDate loanDate, LocalDate returnDate, LoanStatus status) {
        if (user == null) throw new UserNotFoundException("User must be informed.");
        if (book == null) throw new BookNotFoundException("Book must be informed.");
        if (loanDate == null) throw new IllegalArgumentException("Loan Date must be informed.");

        this.id = id;
        this.books = book;
        this.user = user;
        this.loanDate = loanDate;
        this.dueDate = loanDate.plusDays(LOAN_PERIOD_DAYS);
        this.returnDate = returnDate;
        this.status = status;
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

    public void returnBook(LocalDate returnDate) {
        if(this.returnDate != null) {
            throw new IllegalStateException("This book have already been returned.");
        }

        this.returnDate = returnDate;
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
