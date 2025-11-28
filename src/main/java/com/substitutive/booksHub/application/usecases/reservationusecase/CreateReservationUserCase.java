package com.substitutive.booksHub.application.usecases.reservationusecase;

import com.substitutive.booksHub.application.dtos.reservationdto.ReservationRequestDto;
import com.substitutive.booksHub.application.dtos.reservationdto.ReservationResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.entities.Reservation;
import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.exceptions.BookNotAvailableException;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.exceptions.UserNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import com.substitutive.booksHub.domain.repositories.ReservationDomainRepository;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Caso de uso responsável por criar uma reserva de livro para um usuário.
 *
 * <p>Este caso de uso realiza as seguintes ações:
 * <ul>
 *     <li>Valida se o usuário existe, caso contrário lança {@link UserNotFoundException};</li>
 *     <li>Valida se o livro existe, caso contrário lança {@link BookNotFoundException};</li>
 *     <li>Verifica se o livro está disponível para reserva, caso contrário lança {@link BookNotAvailableException};</li>
 *     <li>Cria a reserva no repositório e marca o livro como reservado;</li>
 *     <li>Retorna um {@link ReservationResponseDto} com os dados da reserva criada.</li>
 * </ul>
 */
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

        Reservation savedReservation;

        if (book.isAvailable()) {
            Reservation reservation = new Reservation(user, book);
            savedReservation = reservationDomainRepository.save(reservation);
        } else {
            throw new BookNotAvailableException("This book is not available.");
        }

        book.reservation();
        bookDomainRepository.save(book);

        return ReservationResponseDto.fromDomain(savedReservation);
    }
}
