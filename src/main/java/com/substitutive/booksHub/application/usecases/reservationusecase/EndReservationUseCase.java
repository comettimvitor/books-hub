package com.substitutive.booksHub.application.usecases.reservationusecase;

import com.substitutive.booksHub.application.dtos.bookdto.BookResponseDto;
import com.substitutive.booksHub.domain.entities.Book;
import com.substitutive.booksHub.domain.exceptions.BookNotFoundException;
import com.substitutive.booksHub.domain.repositories.BookDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Caso de uso responsável por encerrar a reserva de um livro.
 *
 * <p>Este caso de uso realiza as seguintes ações:
 * <ul>
 *     <li>Recupera o livro associado à reserva pelo ID da reserva;</li>
 *     <li>Se o livro não for encontrado, lança {@link BookNotFoundException};</li>
 *     <li>Finaliza a transação de reserva do livro;</li>
 *     <li>Salva o estado atualizado do livro no repositório;</li>
 *     <li>Retorna os dados do livro atualizado em {@link BookResponseDto}.</li>
 * </ul>
 */
@Service
@RequiredArgsConstructor
public class EndReservationUseCase {
    private final BookDomainRepository bookDomainRepository;

    @Transactional
    public BookResponseDto execute(Long id) {
        Book book = bookDomainRepository.findBookByReservationId(id).orElseThrow(() -> new BookNotFoundException("Book not found."));
        book.endTransaction();
        bookDomainRepository.save(book);
        return BookResponseDto.fromDomain(book);
    }
}
