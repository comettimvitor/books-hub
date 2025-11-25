package com.substitutive.booksHub.application.usecases.reservationusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EndReservationUseCase {
    private final BookDomainRepository bookDomainRepository;

    @Transactional
    public BookResponseDto execute(Long id) {
        Book book = bookDomainRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found."));
        book.endTransaction();
        bookDomainRepository.save(book);
        return BookResponseDto.fromDomain(book);
    }
}
