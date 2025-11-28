package com.substitutive.booksHub.infrastructure.persistence.entities;

import com.substitutive.booksHub.domain.enums.UserType;
import com.substitutive.booksHub.domain.valueobjects.CPF;
import com.substitutive.booksHub.domain.valueobjects.Email;
import com.substitutive.booksHub.domain.valueobjects.Telephone;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
/**
 * Representa um usuário registrado no sistema.
 *
 * <p>Esta entidade é mapeada para a tabela {@code users} e contém informações
 * pessoais, tipos de usuário e relacionamentos com empréstimos e reservas.</p>
 *
 * <p>Os principais dados armazenados são:</p>
 * <ul>
 *     <li>Nome do usuário;</li>
 *     <li>CPF ({@link CPF});</li>
 *     <li>E-mail ({@link Email});</li>
 *     <li>Telefone ({@link Telephone});</li>
 *     <li>Tipo de usuário ({@link UserType});</li>
 * </ul>
 *
 * <p>Um usuário pode possuir múltiplos empréstimos ({@link LoanEntity}) e
 * múltiplas reservas ({@link ReservationEntity}). Ambas coleções utilizam
 * <code>cascade = CascadeType.ALL</code> e <code>orphanRemoval = true</code> para
 * garantir sincronização adequada entre o domínio e o banco.</p>
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private CPF cpf;
    private Email email;
    private Telephone telephone;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<LoanEntity> loans = new ArrayList<>();

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ReservationEntity> reservations = new ArrayList<>();

    public UserEntity(Long id, String name, CPF cpf, Email email, Telephone telephone, UserType userType) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telephone = telephone;
        this.userType = userType;
    }
}
