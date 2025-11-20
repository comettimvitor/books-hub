package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteUserUseCase {
    private final UserDomainRepository userDomainRepository;

    public void execute(Long id) {
        userDomainRepository.delete(id);
    }
}
