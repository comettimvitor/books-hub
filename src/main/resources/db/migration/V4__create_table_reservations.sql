CREATE SEQUENCE reservations_seq
START WITH 1
INCREMENT BY 1
NO MINVALUE
NO MAXVALUE CACHE 1;

CREATE TABLE reservations (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    book_id BIGINT NOT NULL UNIQUE,
    reservation_date DATE NOT NULL,
    CONSTRAINT fk_reservations_user FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE,
    CONSTRAINT fk_reservations_book FOREIGN KEY (book_id)
        REFERENCES books (id)
        ON DELETE CASCADE
);