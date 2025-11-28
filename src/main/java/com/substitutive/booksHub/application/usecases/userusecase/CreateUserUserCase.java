package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.application.dtos.userdto.UserRequestDto;
import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.exceptions.UserAlreadyExistsException;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Caso de uso responsável por criar um novo usuário no sistema.
 *
 * <p>Este caso de uso realiza as seguintes ações:
 * <ul>
 *     <li>Verifica se já existe um usuário com o mesmo CPF, lançando {@link UserAlreadyExistsException} caso exista;</li>
 *     <li>Converte o DTO {@link UserRequestDto} em entidade {@link User};</li>
 *     <li>Persiste o usuário no repositório;</li>
 *     <li>Retorna um {@link UserResponseDto} com os dados do usuário criado.</li>
 * </ul>
 */
@Service
@RequiredArgsConstructor
public class CreateUserUserCase {
    private final UserDomainRepository userDomainRepository;

    @Transactional
    public UserResponseDto execute(UserRequestDto requestDto) {
        if (userDomainRepository.existsByCpf(requestDto.cpf())) {
            throw new UserAlreadyExistsException("A user with this CPF already exists.");
        }

        User user = requestDto.toDomain();
        User saved = userDomainRepository.save(user);
        return UserResponseDto.fromDomain(saved);
    }
}
