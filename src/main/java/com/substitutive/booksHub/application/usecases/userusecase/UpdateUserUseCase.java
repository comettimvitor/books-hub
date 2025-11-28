package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.exceptions.UserAlreadyExistsException;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Caso de uso responsável por atualizar os dados de um usuário existente.
 *
 * <p>Este caso de uso verifica se já existe um usuário com o CPF informado antes de atualizar.
 * Se o CPF já existir em outro usuário, lança uma {@link UserAlreadyExistsException}.
 * Caso contrário, atualiza o usuário no repositório de domínio {@link UserDomainRepository}
 * e retorna um {@link UserResponseDto} representando o usuário atualizado.
 */
@Service
@RequiredArgsConstructor
public class UpdateUserUseCase {
    private final UserDomainRepository userDomainRepository;

    public UserResponseDto execute(Long id, User user) {
        if (userDomainRepository.existsByCpf(user.getCpf())) {
            throw new UserAlreadyExistsException("A user with this CPF already exists.");
        }

        var updateUser = userDomainRepository.update(id, user);
        return UserResponseDto.fromDomain(updateUser);
    }
}
