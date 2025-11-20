package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.application.dtos.userdto.UserRequestDto;
import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.domain.entities.User;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateUserUserCase {
    private final UserDomainRepository userDomainRepository;

    @Transactional
    public UserResponseDto execute(UserRequestDto requestDto) {
        User user = requestDto.toDomain();
        User saved = userDomainRepository.save(user);
        return UserResponseDto.fromDomain(user);
    }
}
