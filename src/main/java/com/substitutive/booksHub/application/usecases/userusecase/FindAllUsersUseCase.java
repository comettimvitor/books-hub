package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso responsável por buscar todos os usuários do sistema.
 *
 * <p>Este caso de uso retorna uma lista de DTOs representando os usuários encontrados
 * no repositório de domínio {@link UserDomainRepository}.
 */
@Service
@RequiredArgsConstructor
public class FindAllUsersUseCase {
    private final UserDomainRepository userDomainRepository;

    public List<UserResponseDto> execute() {
        return userDomainRepository.findAll().stream().map(UserResponseDto::fromDomain).toList();
    }
}
