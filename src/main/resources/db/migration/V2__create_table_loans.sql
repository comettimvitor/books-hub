CREATE TABLE loans (
    id SERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    loan_date DATE NOT NULL,
    due_date DATE NOT NULL,
    return_date DATE,
    status VARCHAR(50) NOT NULL,
    CONSTRAINT fk_loans_user FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON DELETE CASCADE
);