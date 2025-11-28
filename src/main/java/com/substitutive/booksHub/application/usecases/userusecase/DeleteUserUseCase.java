package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.TransientObjectException;
import org.springframework.stereotype.Service;

/**
 * Caso de uso responsável por deletar um usuário do sistema.
 *
 * <p>Este caso de uso realiza as seguintes ações:
 * <ul>
 *     <li>Tenta deletar o usuário com o ID fornecido usando {@link UserDomainRepository};</li>
 *     <li>Caso o usuário possua referências em outras entidades e não possa ser deletado,
 *     lança {@link TransientObjectException} com uma mensagem explicativa.</li>
 * </ul>
 */
@Service
@RequiredArgsConstructor
public class DeleteUserUseCase {
    private final UserDomainRepository userDomainRepository;

    public void execute(Long id) {
        try {
            userDomainRepository.delete(id);
        } catch (TransientObjectException ex) {
            throw new TransientObjectException("Transient Object Exception: There is a reference to this object.");
        }
    }
}
