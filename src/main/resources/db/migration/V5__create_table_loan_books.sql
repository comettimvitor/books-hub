CREATE SEQUENCE loan_books_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE CACHE 1;

CREATE TABLE loan_books (
    loan_books_id BIGINT NOT NULL PRIMARY KEY,
    loan_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL,
    CONSTRAINT fk_loan_books_loan FOREIGN KEY (loan_id) REFERENCES loans (id),
    CONSTRAINT fk_loan_books_book FOREIGN KEY (book_id) REFERENCES books (id)
);