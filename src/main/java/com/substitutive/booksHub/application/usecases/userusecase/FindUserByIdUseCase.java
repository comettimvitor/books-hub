package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.domain.exceptions.UserNotFoundException;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Caso de uso responsável por buscar um usuário pelo seu ID.
 *
 * <p>Este caso de uso consulta o repositório de domínio {@link UserDomainRepository} para
 * encontrar o usuário pelo ID fornecido. Caso o usuário não seja encontrado,
 * lança a exceção {@link UserNotFoundException}.
 */
@Service
@RequiredArgsConstructor
public class FindUserByIdUseCase {
    private final UserDomainRepository userDomainRepository;

    public UserResponseDto execute(Long id) {
        return userDomainRepository.findById(id).map(UserResponseDto::fromDomain).orElseThrow(() -> new UserNotFoundException("User not found."));
    }
}
