package com.substitutive.booksHub.domain.valueobjects;

import com.substitutive.booksHub.domain.exceptions.InvalidEmailException;
/**
 * Representa um endereço de e-mail como um value object imutável.
 * <p>
 * Esta classe garante que o valor informado siga um padrão básico de e-mail,
 * validando a presença de um identificador de usuário, o caractere '@' e um domínio
 * com extensão de pelo menos 2 letras.
 * </p>
 *
 * <p>Exemplos de uso:</p>
 * <pre>{@code
 * Email email = new Email("usuario@dominio.com");
 * System.out.println(email); // imprime: usuario@dominio.com
 * }</pre>
 *
 * @param value o endereço de e-mail informado pelo usuário
 * @throws InvalidEmailException se o valor for nulo ou não corresponder ao padrão básico de e-mail
 */
public record Email(String value) {
    public Email {
        if (value == null || !value.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new InvalidEmailException("Invalid E-mail.");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
