package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteBookUseCase {
    private final BookDomainRepository bookDomainRepository;

    public void execute(Long id) {
        bookDomainRepository.delete(id);
    }
}
