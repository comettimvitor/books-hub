package com.substitutive.booksHub.infrastructure.persistence.mappers;

import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.infrastructure.persistence.entities.UserEntity;

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
