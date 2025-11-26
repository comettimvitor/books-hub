package com.substitutive.booksHub.domain.entities;

import com.substitutive.booksHub.domain.enums.BookStatus;
import com.substitutive.booksHub.domain.exceptions.ReservedBookException;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;

public class Book {

    private Long id;
    private String title;
    private String author;
    private InternationalStandardBookNumber isbn;
    private BookStatus status;
    private boolean isAvailable;

    public Book(Long id, String title, String author, InternationalStandardBookNumber isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public Book(Long id, String title, String author, InternationalStandardBookNumber isbn, BookStatus bookStatus, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.status = bookStatus;
        this.isAvailable = isAvailable;
    }

    public void reservation() {
        if(!this.isAvailable) {
            throw new ReservedBookException("This book is already reserved");
        }

        isAvailable = false;
        status = BookStatus.RESERVED;
    }

    public void endTransaction() {
        isAvailable = true;
        status = BookStatus.AVAILABLE;
    }

    public void loan() {
        if (!this.isAvailable) {
            throw new IllegalStateException("This book is not available.");
        }

        isAvailable = false;
        status = BookStatus.BORROWED;
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
