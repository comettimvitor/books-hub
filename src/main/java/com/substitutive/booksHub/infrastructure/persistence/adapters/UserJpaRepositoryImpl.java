package com.substitutive.booksHub.infrastructure.persistence.adapters;

import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.exceptions.UserNotFoundException;
import com.substitutive.booksHub.domain.repositories.UserRepository;
import com.substitutive.booksHub.infrastructure.persistence.mappers.UserMapper;
import com.substitutive.booksHub.infrastructure.persistence.repositories.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserJpaRepositoryImpl implements UserRepository {

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
    public Optional<User> findByUserName(String name) {
        return userJpaRepository.findByUserName(name).map(UserMapper::toDomain);
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
        userJpaRepository.deleteById(id);
    }
}
