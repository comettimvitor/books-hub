package com.substitutive.booksHub.infrastructure.persistence.adapters;

import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.exceptions.UserNotFoundException;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import com.substitutive.booksHub.domain.valueobjects.CPF;
import com.substitutive.booksHub.infrastructure.persistence.mappers.UserMapper;
import com.substitutive.booksHub.infrastructure.persistence.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 * Implementação do {@link UserDomainRepository} utilizando Spring Data JPA.
 * <p>
 * Atua como adaptador entre o domínio e a camada de persistência,
 * convertendo objetos de domínio em entidades JPA e vice-versa
 * utilizando o {@link UserMapper}.
 * </p>
 *
 * <p>
 * Responsável por operações de persistência e consulta de usuários,
 * incluindo criação, atualização, exclusão e verificações específicas
 * como existência por CPF.
 * </p>
 */
@Repository
@RequiredArgsConstructor
public class UserJpaDomainRepositoryImpl implements UserDomainRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {
        var userEntity = UserMapper.toEntity(user);
        var savedUser = userJpaRepository.save(userEntity);
        return UserMapper.toDomain(savedUser);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userJpaRepository.findById(id).map(UserMapper::toDomain);
    }

    @Override
    public List<User> findUserByName(String name) {
        return userJpaRepository.findUserByName(name).stream().map(UserMapper::toDomain).toList();
    }

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll().stream().map(UserMapper::toDomain).toList();
    }

    @Override
    public User update(Long id, User user) {
        var entity = userJpaRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found for update."));

        entity.setName(user.getName());
        entity.setCpf(user.getCpf());
        entity.setEmail(user.getEmail());
        entity.setTelephone(user.getTelephone());
        entity.setUserType(user.getUserType());

        var saved = userJpaRepository.save(entity);
        return UserMapper.toDomain(saved);
    }

    @Override
    public void delete(Long id) {
        var user = userJpaRepository.findById(id);

        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found with id: " + id);
        }

        userJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByCpf(CPF cpf) {
        return userJpaRepository.existsByCpf(cpf);
    }
}
