package com.substitutive.booksHub.infrastructure.persistence.mappers;

import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.infrastructure.persistence.entities.UserEntity;
/**
 * Classe responsável por realizar a conversão entre o objeto de domínio {@link User}
 * e a entidade {@link UserEntity} utilizada pela camada de persistência (JPA).
 *
 * <p>O objetivo desta classe é garantir o isolamento entre a camada de domínio
 * e a infraestrutura, evitando que regras de negócio dependam de detalhes
 * de banco de dados.</p>
 *
 * <p>Principais responsabilidades:</p>
 * <ul>
 *   <li>Converter {@link User} para {@link UserEntity};</li>
 *   <li>Converter {@link UserEntity} para {@link User};</li>
 *   <li>Preservar os value objects utilizados no domínio (CPF, Email, Telephone);</li>
 *   <li>Evitar acoplamento direto entre domínio e JPA.</li>
 * </ul>
 */
public class UserMapper {
    public static UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getEmail(),
                user.getTelephone(),
                user.getUserType()
        );
    }

    public static User toDomain(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getCpf(),
                userEntity.getEmail(),
                userEntity.getTelephone(),
                userEntity.getUserType()
        );
    }
}
