package com.substitutive.booksHub.infrastructure.persistence.projections;

import java.util.Date;
/**
 * Projeção utilizada para representar informações básicas de um livro emprestado. Utilizado no relatorio
 * de livros emprestados no momento.
 * <p>
 * Essa interface é usada em consultas (por exemplo, com Spring Data JPA) para
 * retornar somente os campos necessários, sem precisar carregar a entidade completa.
 */
public interface BorrowedBooksProjection {
    Long getId();

    String getTitle();

    String getAuthor();

    String getIsbn();

    Date getDueDate();
}
