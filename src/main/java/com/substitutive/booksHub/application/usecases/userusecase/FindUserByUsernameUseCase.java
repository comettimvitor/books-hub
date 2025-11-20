package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.domain.exceptions.UserNotFoundException;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindUserByUsernameUseCase {
    public final UserDomainRepository userDomainRepository;

    public UserResponseDto execute(String name) {
        return userDomainRepository.findByUserName(name).map(UserResponseDto::fromDomain).orElseThrow(() -> new UserNotFoundException("User not found with username: " + name));
    }
}
