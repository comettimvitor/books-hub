package com.substitutive.booksHub.application.usecases.bookusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BorrowedBooksResponseDto;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowedBooksUseCase {
    private final BookDomainRepository bookDomainRepository;

    public List<BorrowedBooksResponseDto> execute() {
        return bookDomainRepository.borrowedBooks().stream().map(BorrowedBooksResponseDto::fromDomain).toList();
    }
}
