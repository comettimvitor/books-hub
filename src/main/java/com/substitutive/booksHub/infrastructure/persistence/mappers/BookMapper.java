package com.substitutive.booksHub.infrastructure.persistence.mappers;

import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import com.substitutive.booksHub.infrastructure.persistence.entities.BookEntity;

public class BookMapper {

    public static BookEntity toEntity(Book book) {
        return new BookEntity(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn().toString(),
                book.getStatus(),
                book.isAvailable()
        );
    }

    public static Book toDomain(BookEntity bookEntity) {
        return new Book(
                bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getAuthor(),
                new InternationalStandardBookNumber(bookEntity.getIsbn()),
                bookEntity.getStatus(),
                bookEntity.isAvailable()
        );
    }
}
