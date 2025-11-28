package com.substitutive.booksHub.application.usecases.loanusecase;

import com.substitutive.booksHub.domain.repositories.LoanDomainRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.TransientObjectException;
import org.springframework.stereotype.Service;
/**
 * Caso de uso responsável por excluir um empréstimo.
 *
 * <p>Exclui um empréstimo pelo seu ID. Caso haja referências pendentes no banco
 * de dados que impeçam a exclusão, será lançada uma {@link TransientObjectException}.
 */
@Service
@RequiredArgsConstructor
public class DeleteLoanUseCase {
    private final LoanDomainRepository loanDomainRepository;

    public void execute(Long id) {
        try{
            loanDomainRepository.delete(id);
        } catch (TransientObjectException ex) {
            throw new TransientObjectException("Transient Object Exception: There is a reference to this object.");
        }
    }
}
