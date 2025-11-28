package com.substitutive.booksHub.infrastructure.persistence.mappers;

import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import com.substitutive.booksHub.infrastructure.persistence.entities.BookEntity;
/**
 * Classe utilitária responsável por converter objetos entre o domínio
 * ({@link Book}) e a entidade persistida ({@link BookEntity}).
 *
 * <p>Os mapeadores garantem que as regras do domínio sejam preservadas
 * ao transformar objetos para persistência e vice-versa.</p>
 *
 * <p>Este mapper realiza:</p>
 * <ul>
 *     <li>Conversão de {@link Book} para {@link BookEntity};</li>
 *     <li>Conversão de {@link BookEntity} para {@link Book};</li>
 *     <li>Tratamento do ISBN como {@link InternationalStandardBookNumber}.</li>
 * </ul>
 */
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
