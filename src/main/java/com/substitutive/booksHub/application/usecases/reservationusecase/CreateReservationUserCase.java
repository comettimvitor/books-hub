package com.substitutive.booksHub.application.usecases.reservationusecase;

import com.substitutive.booksHub.application.dtos.reservationdto.ReservationRequestDto;
import com.substitutive.booksHub.application.dtos.reservationdto.ReservationResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.entities.Reservation;
import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.exceptions.UserNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import com.substitutive.booksHub.domain.repositories.ReservationDomainRepository;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateReservationUserCase {
    private final ReservationDomainRepository reservationDomainRepository;
    private final UserDomainRepository userDomainRepository;
    private final BookDomainRepository bookDomainRepository;

    @Transactional
    public ReservationResponseDto execute(ReservationRequestDto request) {
        User user = userDomainRepository.findById(request.userId()).orElseThrow(() -> new UserNotFoundException("User not found."));
        Book book = bookDomainRepository.findById(request.bookId()).orElseThrow(() -> new BookNotFoundException("Book not found."));
        book.reservation();
        bookDomainRepository.save(book);

        Reservation reservation = new Reservation(user, book);
        Reservation savedReservation = reservationDomainRepository.save(reservation);

        return ReservationResponseDto.fromDomain(savedReservation);
    }
}
