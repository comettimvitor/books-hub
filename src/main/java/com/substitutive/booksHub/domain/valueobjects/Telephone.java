package com.substitutive.booksHub.domain.valueobjects;

import com.substitutive.booksHub.domain.exceptions.InvalidTelephoneException;
/**
 * Representa um número de telefone como um value object imutável.
 * <p>
 * Esta classe valida o telefone informado utilizando uma expressão regular que aceita:
 * </p>
 *
 * <ul>
 *     <li>Formato com DDD entre parênteses (ex.: {@code (27) 99999-9999})</li>
 *     <li>Formato com DDI opcional (ex.: {@code +55 27 99999-9999})</li>
 *     <li>Números de 8 ou 9 dígitos (ex.: {@code 3333-4444} ou {@code 99999-9999})</li>
 * </ul>
 *
 * <p>
 * O valor é armazenado exatamente como informado. Esta classe não remove formatação,
 * apenas valida se o padrão é aceitável.
 * </p>
 *
 * <p>Exemplo de uso:</p>
 * <pre>{@code
 * Telephone t1 = new Telephone("(27) 99999-9999");
 * Telephone t2 = new Telephone("+55 27 99999-9999");
 *
 * System.out.println(t1); // (27) 99999-9999
 * System.out.println(t2); // +55 27 99999-9999
 * }</pre>
 *
 * @param value o número de telefone informado pelo usuário
 * @throws InvalidTelephoneException se o telefone for nulo, vazio ou não corresponder ao padrão aceito
 */
public record Telephone(String value) {
    public Telephone {
        if (value == null || value.isBlank()) {
            throw new InvalidTelephoneException("Telephone can't be null or empty.");
        }

        String regex = "^(\\+\\d{1,3}\\s?)?(\\(?\\d{2}\\)?\\s?)?\\d{4,5}-?\\d{4}$";

        if (!value.matches(regex)) {
            throw new InvalidTelephoneException("Invalid telephone. Ex: (27) 99999-9999 or +55 27 99999-9999");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
