package com.substitutive.booksHub.domain.entities;

import com.substitutive.booksHub.domain.enums.BookStatus;
import com.substitutive.booksHub.domain.exceptions.BorrowedBookException;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Book {

    private Long id;
    private String title;
    private String author;
    private InternationalStandardBookNumber isbn;
    private BookStatus status;
    private boolean isAvailable;
    private List<Reservation> reservations = new ArrayList<>();

    public Book(Long id, String title, String author, InternationalStandardBookNumber isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = BookStatus.AVAILABLE;
        this.isAvailable = true;
    }

    public void reserve(User user) {
        if(this.isAvailable) {
            throw new IllegalStateException("This book is available.");
        }

        if(reservations.stream().anyMatch(reservation -> reservation.getUser().equals(user))) {
            throw new IllegalStateException("User is already in the reservation queue.");
        }

        reservations.add(new Reservation(user, this));
    }

    public Optional<User> nextInQueue() {
        return reservations.isEmpty() ? Optional.empty() : Optional.of(reservations.get(0).getUser());
    }

    public void removerFirstReservation() {
        if(!reservations.isEmpty()) {
            reservations.remove(0);
        }
    }

    public List<Reservation> getReservations() {
        return Collections.unmodifiableList(reservations);
    }

    public void markAsBorrowed() {
        if(this.status == BookStatus.BORROWED) {
            throw new BorrowedBookException("This book have already been borrowed.");
        }

        this.status = BookStatus.BORROWED;
        this.isAvailable = false;
    }

    public void markAsAvailable() {
        this.status = BookStatus.AVAILABLE;
        this.isAvailable = true;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public InternationalStandardBookNumber getIsbn() {
        return isbn;
    }

    public void setIsbn(InternationalStandardBookNumber isbn) {
        this.isbn = isbn;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
