package com.substitutive.booksHub.domain.entities;

import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.exceptions.UserNotFoundException;

import java.time.LocalDate;

public class Reservation {

    private Long id;
    private User user;
    private Book book;
    private LocalDate reservationDate;

    public Reservation(Long id, User user, Book book, LocalDate reservationDate) {
        if (user == null) throw new UserNotFoundException("User must be informed.");
        if (book == null) throw new BookNotFoundException("Book must be informed.");

        this.id = id;
        this.user = user;
        this.book = book;
        this.reservationDate = reservationDate;
    }

    public Reservation(User user, Book book) {
        if (user == null) throw new UserNotFoundException("User must be informed.");
        if (book == null) throw new BookNotFoundException("Book must be informed");

        this.user = user;
        this.book = book;
        this.reservationDate = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }
}
