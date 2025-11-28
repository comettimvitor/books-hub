package com.substitutive.booksHub.application.dtos.loandto;

import java.util.List;

/**
 * DTO de requisição para criar um empréstimo.
 *
 * <p>Contém o identificador do usuário que realizará o empréstimo e
 * uma lista de identificadores dos livros que serão emprestados.
 */
public record LoanRequestDto(
        List<Long> bookIds,
        Long userId
) {
}
