package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.TransientObjectException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserUseCase {
    private final UserDomainRepository userDomainRepository;

    public void execute(Long id) {
        try{
            userDomainRepository.delete(id);
        } catch (TransientObjectException ex) {
            throw new TransientObjectException("Transient Object Exception: There is a reference to this object.");
        }
    }
}
