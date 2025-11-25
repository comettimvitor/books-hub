package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.exceptions.UserAlreadyExistsException;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateUserUseCase {
    private final UserDomainRepository userDomainRepository;

    public UserResponseDto execute(Long id, User user) {
        if(userDomainRepository.existsByCpf(user.getCpf())) {
            throw new UserAlreadyExistsException("A user with this CPF already exists.");
        }

        var updateUser = userDomainRepository.update(id, user);
        return UserResponseDto.fromDomain(updateUser);
    }
}
