package com.substitutive.booksHub.infrastructure.persistence.projections;

import java.util.Date;

public interface BorrowedBooksProjection {
    Long getId();

    String getTitle();

    String getAuthor();

    String getIsbn();

    Date getDueDate();
}
