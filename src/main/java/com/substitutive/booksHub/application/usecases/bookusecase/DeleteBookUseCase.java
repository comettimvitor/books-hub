package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.TransientObjectException;
import org.springframework.stereotype.Service;
/**
 * Caso de uso responsável por deletar um livro existente no sistema.
 *
 * <p>Este caso de uso delega a exclusão ao repositório de livros.
 * Caso o livro esteja referenciado por outras entidades e não possa ser deletado,
 * lança uma {@link TransientObjectException} informando que há referências ao objeto.
 */
@Service
@RequiredArgsConstructor
public class DeleteBookUseCase {
    private final BookDomainRepository bookDomainRepository;

    public void execute(Long id) {
        try{
            bookDomainRepository.delete(id);
        } catch (TransientObjectException ex) {
            throw new TransientObjectException("Transient Object Exception: There is a reference to this object.");
        }
    }
}
