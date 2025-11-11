package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.domain.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteBookUseCase {
    private final BookRepository bookRepository;

    public void execute(Long id) {
        bookRepository.delete(id);
    }
}
