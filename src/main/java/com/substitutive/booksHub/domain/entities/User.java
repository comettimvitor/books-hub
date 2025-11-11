package com.substitutive.booksHub.domain.entities;

import com.substitutive.booksHub.domain.enums.UserType;
import com.substitutive.booksHub.domain.valueobjects.CPF;
import com.substitutive.booksHub.domain.valueobjects.Email;
import com.substitutive.booksHub.domain.valueobjects.Telephone;

public class User {

    private Long id;
    private String name;
    private CPF cpf;
    private Email email;
    private Telephone telephone;
    private UserType userType;

    public User(Long id, String name, CPF cpf, Email email, Telephone telephone, UserType userType) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telephone = telephone;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserTypeAsStudent() {
        this.userType = UserType.STUDENT;
    }

    public void setUserTypeAsBookstoreMember() {
        this.userType = UserType.BOOKSTORE_MEMBER;
    }
}
