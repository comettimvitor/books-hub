package com.substitutive.booksHub.application.usecases.userusecase;

import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.domain.repositories.UserDomainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllUsersUseCase {
    private final UserDomainRepository userDomainRepository;

    public List<UserResponseDto> execute() {
        return userDomainRepository.findAll().stream().map(UserResponseDto::fromDomain).toList();
    }
}
