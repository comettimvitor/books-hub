package com.substitutive.booksHub.application.dtos.userdto;

import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.enums.UserType;
import com.substitutive.booksHub.domain.valueobjects.CPF;
import com.substitutive.booksHub.domain.valueobjects.Email;
import com.substitutive.booksHub.domain.valueobjects.Telephone;
/**
 * DTO de requisição para criação ou atualização de um usuário.
 *
 * <p>Contém informações necessárias para criar ou atualizar um usuário no sistema.
 */
public record UserRequestDto(
        String name,
        CPF cpf,
        Email email,
        Telephone telephone,
        UserType userType
) {
    public User toDomain() {
        return new User(name, cpf, email, telephone, userType);
    }
}
