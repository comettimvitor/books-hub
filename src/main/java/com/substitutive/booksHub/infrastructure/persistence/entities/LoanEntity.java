package com.substitutive.booksHub.infrastructure.persistence.entities;

import com.substitutive.booksHub.domain.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
/**
 * Representa um registro de empréstimo no sistema, contendo informações
 * sobre os livros emprestados, o usuário que realizou o empréstimo,
 * as datas importantes e o status atual do empréstimo.
 *
 * <p>Esta entidade é mapeada para a tabela {@code loans} e possui:
 * <ul>
 *     <li>Uma relação muitos-para-muitos com {@link BookEntity}, armazenada
 *     na tabela de junção {@code loan_books}.</li>
 *
 *     <li>Uma relação muitos-para-um com {@link UserEntity}, representando
 *     o usuário que realizou o empréstimo.</li>
 * </ul>
 *
 * <p>Cada empréstimo também armazena sua data de criação, data de devolução prevista,
 * data de devolução real (quando houver) e um {@link LoanStatus} indicando
 * o estado atual do empréstimo.
 */
@Entity
@Table(name = "loans")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class LoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "loan_books",
            joinColumns = @JoinColumn(name = "loan_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<BookEntity> books;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;
    private LocalDate loanDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;
}
