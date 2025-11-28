package com.substitutive.booksHub.infrastructure.converters;

import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
/**
 * Converter JPA responsável por transformar o value object
 * {@link InternationalStandardBookNumber} (ISBN) em sua representação textual
 * para armazenamento no banco de dados, e vice-versa.
 *
 * <p>
 * Com a anotação {@link Converter} e {@code autoApply = true}, este conversor
 * é aplicado automaticamente a todos os atributos do tipo
 * {@link InternationalStandardBookNumber} nas entidades JPA,
 * sem a necessidade de anotar cada campo individualmente.
 * </p>
 *
 * <h2>Responsabilidades</h2>
 * <ul>
 *     <li>Converter um objeto ISBN para {@link String} ao salvar no banco.</li>
 *     <li>Reconstruir um ISBN a partir da {@link String} armazenada.</li>
 *     <li>Garantir que as validações do próprio value object sejam aplicadas
 *     durante a conversão.</li>
 * </ul>
 *
 * <p>Ambos os métodos lidam com valores {@code null} de forma segura.</p>
 */
@Converter(autoApply = true)
public class IsbnConverter implements AttributeConverter<InternationalStandardBookNumber, String> {

    @Override
    public String convertToDatabaseColumn(InternationalStandardBookNumber isbn) {
        return isbn == null ? null : isbn.value();
    }

    @Override
    public InternationalStandardBookNumber convertToEntityAttribute(String value) {
        return value == null ? null : new InternationalStandardBookNumber(value);
    }
}