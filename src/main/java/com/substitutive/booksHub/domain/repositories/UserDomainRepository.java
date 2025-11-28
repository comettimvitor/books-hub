package com.substitutive.booksHub.domain.repositories;

import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.valueobjects.CPF;

import java.util.List;
import java.util.Optional;
/**
 * Repositório de domínio responsável por operações relacionadas à entidade {@link User}.
 *
 * <p>
 * Define os contratos essenciais para persistência, consulta e manipulação de usuários
 * dentro do contexto do sistema BookHub. Segue os princípios de DDD, mantendo o domínio
 * independente dos detalhes da camada de infraestrutura.
 * </p>
 */
public interface UserDomainRepository {
    User save(User user);

    Optional<User> findById(Long id);

    List<User> findUserByName(String name);

    List<User> findAll();

    User update(Long id, User user);

    void delete(Long id);

    boolean existsByCpf(CPF cpf);
}
