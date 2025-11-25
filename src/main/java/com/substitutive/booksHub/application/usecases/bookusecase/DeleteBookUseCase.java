package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.TransientObjectException;
import org.springframework.stereotype.Service;

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
