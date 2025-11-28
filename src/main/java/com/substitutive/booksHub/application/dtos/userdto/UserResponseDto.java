package com.substitutive.booksHub.application.dtos.userdto;

import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.enums.UserType;
import com.substitutive.booksHub.domain.valueobjects.CPF;
import com.substitutive.booksHub.domain.valueobjects.Email;
import com.substitutive.booksHub.domain.valueobjects.Telephone;

/**
 * DTO de resposta para informações de um usuário.
 *
 * <p>Utilizado para retornar dados de um usuário através das APIs, encapsulando
 * informações essenciais da entidade de domínio {@link User}.
 */
public record UserResponseDto(
        Long id,
        String name,
        CPF cpf,
        Email email,
        Telephone telephone,
        UserType userType
) {
    public static UserResponseDto fromDomain(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getEmail(),
                user.getTelephone(),
                user.getUserType()
        );
    }
}
