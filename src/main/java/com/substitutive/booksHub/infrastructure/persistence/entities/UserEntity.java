package com.substitutive.booksHub.infrastructure.persistence.entities;

import com.substitutive.booksHub.domain.enums.UserType;
import com.substitutive.booksHub.domain.valueobjects.CPF;
import com.substitutive.booksHub.domain.valueobjects.Email;
import com.substitutive.booksHub.domain.valueobjects.Telephone;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
