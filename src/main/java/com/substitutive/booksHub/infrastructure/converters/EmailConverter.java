package com.substitutive.booksHub.infrastructure.converters;

import com.substitutive.booksHub.domain.valueobjects.Email;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
/**
 * Converter JPA responsável por mapear o value object {@link Email} para sua
 * representação em coluna do banco de dados e vice-versa.
 *
 * <p>Marcado com {@link Converter} e {@code autoApply = true}, este conversor
 * é automaticamente aplicado a todos os atributos do tipo {@link Email} em
 * entidades JPA, eliminando a necessidade de anotação explícita em cada campo.
 * </p>
 *
 * <h2>Responsabilidades</h2>
 * <ul>
 *     <li>Converter um {@link Email} para {@link String} ao salvar no banco.</li>
 *     <li>Converter uma {@link String} em uma instância de {@link Email}
 *     ao carregar a entidade.</li>
 *     <li>Delegar ao value object Email a responsabilidade de validar seu formato.</li>
 * </ul>
 *
 * <p>Ambos os métodos lidam com valores {@code null} de forma segura, evitando erros
 * durante operações de leitura ou escrita.</p>
 */
@Converter(autoApply = true)
public class EmailConverter implements AttributeConverter<Email, String> {

    @Override
    public String convertToDatabaseColumn(Email email) {
        return email == null ? null : email.value();
    }

    @Override
    public Email convertToEntityAttribute(String value) {
        return value == null ? null : new Email(value);
    }
}