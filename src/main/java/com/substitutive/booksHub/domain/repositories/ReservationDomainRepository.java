package com.substitutive.booksHub.domain.repositories;

import com.substitutive.booksHub.domain.entities.Reservation;

import java.util.List;
/**
 * Repositório de domínio responsável por operações relacionadas à entidade {@link Reservation}.
 *
 * <p>
 * Define os contratos essenciais para persistência e consulta de reservas de livros
 * dentro do contexto do sistema BookHub.
 * </p>
 *
 * <p>
 * Esta interface segue os princípios de DDD (Domain-Driven Design), mantendo o domínio
 * desacoplado da tecnologia de persistência.
 * </p>
 */
public interface ReservationDomainRepository {
    Reservation save(Reservation reservation);

    List<Reservation> findAllByUser(Long userId);

    List<Reservation> findAllByBookEntity_Id(Long bookId);
}
