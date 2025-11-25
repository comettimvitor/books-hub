package com.substitutive.booksHub.interfaces.controllers;

import com.substitutive.booksHub.application.dtos.userdto.UserRequestDto;
import com.substitutive.booksHub.application.dtos.userdto.UserResponseDto;
import com.substitutive.booksHub.application.usecases.userusecase.*;
import com.substitutive.booksHub.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final CreateUserUserCase createUserUserCase;
    private final DeleteUserUseCase deleteUserUseCase;
    private final FindAllUsersUseCase findAllUsersUseCase;
    private final FindUserByIdUseCase findUserByIdUseCase;
    private final FindUserByNameUseCase findUserByNameUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto request) {
        var response = createUserUserCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        deleteUserUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable("id") Long id) {
        UserResponseDto responseDto = findUserByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping("/name")
    public ResponseEntity<List<UserResponseDto>> findUserByName(@RequestParam String name) {
        List<UserResponseDto> responseDto = findUserByNameUseCase.execute(name);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> findAll() {
        List<UserResponseDto> responseDto = findAllUsersUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable("id") Long id, @RequestBody UserRequestDto userRequestDto) {
        User user = userRequestDto.toDomain();
        UserResponseDto responseDto = updateUserUseCase.execute(id, user);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
