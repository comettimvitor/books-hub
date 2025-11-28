package com.substitutive.booksHub.domain.valueobjects;

import com.substitutive.booksHub.domain.exceptions.InvalidCpfException;
/**
 * Representa um CPF (Cadastro de Pessoa Física) brasileiro como um value object imutável.
 * <p>
 * Esta classe garante que o valor informado seja válido no formato numérico,
 * contendo exatamente 11 dígitos. Caracteres não numéricos são removidos antes da validação.
 * O CPF é armazenado apenas como dígitos, mas seu {@link #toString()} retorna o CPF
 * formatado no padrão XXX.XXX.XXX-XX.
 * </p>
 *
 * <p>Exemplos de uso:</p>
 * <pre>{@code
 * CPF cpf = new CPF("123.456.789-09");
 * System.out.println(cpf); // imprime: 123.456.789-09
 * }</pre>
 *
 * @param value o valor do CPF informado pelo usuário, aceitando formatos com ou sem pontuação
 * @throws InvalidCpfException se o valor for nulo ou vazio
 * @throws IllegalArgumentException se, após limpeza, não possuir exatamente 11 dígitos numéricos
 */
public record CPF(String value) {
    public CPF {
        if (value == null || value.isBlank()) {
            throw new InvalidCpfException("CPF can't be null or empty.");
        }

        String numericCPF = value.replaceAll("\\D", "");

        if (!numericCPF.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF must contain 11 numeric digits.");
        }

        value = numericCPF;
    }

    @Override
    public String toString() {
        return value.substring(0, 3) + "." +
                value.substring(3, 6) + "." +
                value.substring(6, 9) + "-" +
                value.substring(9);
    }
}
