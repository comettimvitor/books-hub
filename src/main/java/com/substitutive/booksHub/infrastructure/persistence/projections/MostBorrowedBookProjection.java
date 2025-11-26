package com.substitutive.booksHub.infrastructure.persistence.projections;

public interface MostBorrowedBookProjection {
    Long getId();

    String getTitle();

    String getAuthor();

    String getIsbn();

    Integer getTotalLoans();
}
