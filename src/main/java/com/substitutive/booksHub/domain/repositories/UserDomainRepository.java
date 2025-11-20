package com.substitutive.booksHub.domain.repositories;

import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.valueobjects.CPF;

import java.util.List;
import java.util.Optional;

public interface UserDomainRepository {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findUserByName(String name);
    List<User> findAll();
    User update(Long id, User user);
    void delete(Long id);
    boolean existsByCpf(CPF cpf);
}
