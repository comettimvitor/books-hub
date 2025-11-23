CREATE TABLE loan_books (
    loan_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    CONSTRAINT fk_loan_books_loan FOREIGN KEY (loan_id) REFERENCES loans (id),
    CONSTRAINT fk_loan_books_book FOREIGN KEY (book_id) REFERENCES books (id)
);