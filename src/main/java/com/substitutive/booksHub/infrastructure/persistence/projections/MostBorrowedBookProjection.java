package com.substitutive.booksHub.infrastructure.persistence.projections;
/**
 * Projeção utilizada para representar dados estatísticos no relatorio sobre os 20 livros mais emprestados.
 * <p>
 * Essa interface é utilizada em consultas (por exemplo, com Spring Data JPA) para
 * retornar apenas as informações essenciais de um livro e a quantidade total de
 * empréstimos, sem carregar a entidade completa.
 */
public interface MostBorrowedBookProjection {
    Long getId();

    String getTitle();

    String getAuthor();

    String getIsbn();

    Integer getTotalLoans();
}
