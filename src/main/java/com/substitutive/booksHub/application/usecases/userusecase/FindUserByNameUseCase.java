package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Caso de uso responsável por buscar usuários pelo nome.
 *
 * <p>Este caso de uso consulta o repositório de domínio {@link UserDomainRepository} para
 * encontrar todos os usuários cujo nome corresponda ao informado. Retorna uma lista de
 * {@link UserResponseDto} representando os usuários encontrados.
 */
@Service
@RequiredArgsConstructor
public class FindUserByNameUseCase {
    public final UserDomainRepository userDomainRepository;

    public List<UserResponseDto> execute(String name) {
        return userDomainRepository.findUserByName(name).stream().map(UserResponseDto::fromDomain).toList();
    }
}
