package com.substitutive.booksHub.domain.valueobjects;

import com.substitutive.booksHub.domain.exceptions.InvalidIsbnException;
/**
 * Representa um ISBN (International Standard Book Number) como um value object imutável.
 * <p>
 * Esta classe valida o ISBN informado garantindo que ele siga o formato:
 * {@code XXX-XX-XXXXX-XX-X}, composto exclusivamente por dígitos separados por hífens.
 * Não realiza validação dos dígitos verificadores, apenas do formato.
 * </p>
 *
 * <p>Exemplo de uso:</p>
 * <pre>{@code
 * InternationalStandardBookNumber isbn =
 *         new InternationalStandardBookNumber("111-12-34567-89-0");
 *
 * System.out.println(isbn); // imprime: 111-12-34567-89-0
 * }</pre>
 *
 * @param value o ISBN informado, devendo corresponder ao formato {@code XXX-XX-XXXXX-XX-X}
 * @throws InvalidIsbnException se o valor for nulo ou não corresponder ao formato exigido
 */
public record InternationalStandardBookNumber(String value) {
    public InternationalStandardBookNumber {
        if(value == null || !value.matches("\\d{3}-\\d{2}-\\d{5}-\\d{2}-\\d{1}")) {
            throw new InvalidIsbnException("Invalid ISBN. Valid number example: 111-12-34567-89-0");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
