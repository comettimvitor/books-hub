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

/**
 * Controlador responsável pelo gerenciamento de usuários no sistema.
 *
 * <p>Este controlador fornece endpoints para:
 * <ul>
 *   <li>Criar um novo usuário;</li>
 *   <li>Deletar um usuário existente;</li>
 *   <li>Buscar usuário por ID;</li>
 *   <li>Buscar usuários por nome;</li>
 *   <li>Listar todos os usuários;</li>
 *   <li>Atualizar dados de um usuário existente;</li>
 * </ul>
 *
 * <p>A lógica de negócio é delegada aos casos de uso correspondentes,
 * garantindo a separação de responsabilidades conforme a Clean Architecture.
 */
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

    /**
     * Cria um novo usuário no sistema.
     *
     * @param request DTO contendo os dados do usuário a ser criado
     * @return DTO com os dados do usuário criado
     */
    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto request) {
        var response = createUserUserCase.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Deleta um usuário existente pelo seu ID.
     *
     * @param id identificador do usuário a ser deletado
     * @return resposta HTTP 204 (No Content) se deletado com sucesso
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        deleteUserUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Busca um usuário pelo seu ID.
     *
     * @param id identificador do usuário
     * @return DTO contendo os dados do usuário encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable("id") Long id) {
        UserResponseDto responseDto = findUserByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Busca usuários pelo nome.
     *
     * @param name nome do usuário a ser pesquisado
     * @return lista de DTOs de usuários que correspondem ao nome informado
     */
    @GetMapping("/name")
    public ResponseEntity<List<UserResponseDto>> findUserByName(@RequestParam String name) {
        List<UserResponseDto> responseDto = findUserByNameUseCase.execute(name);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Retorna todos os usuários cadastrados no sistema.
     *
     * @return lista de DTOs de todos os usuários
     */
    @GetMapping()
    public ResponseEntity<List<UserResponseDto>> findAll() {
        List<UserResponseDto> responseDto = findAllUsersUseCase.execute();
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    /**
     * Atualiza os dados de um usuário existente.
     *
     * @param id             identificador do usuário a ser atualizado
     * @param userRequestDto DTO contendo os novos dados do usuário
     * @return DTO com os dados atualizados do usuário
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable("id") Long id, @RequestBody UserRequestDto userRequestDto) {
        User user = userRequestDto.toDomain();
        UserResponseDto responseDto = updateUserUseCase.execute(id, user);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }
}
