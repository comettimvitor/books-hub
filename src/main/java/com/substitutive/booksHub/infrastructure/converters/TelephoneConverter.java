package com.substitutive.booksHub.infrastructure.converters;

import com.substitutive.booksHub.domain.valueobjects.Telephone;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
/**
 * Converter JPA responsável por mapear o value object {@link Telephone}
 * para sua representação textual no banco de dados e vice-versa.
 *
 * <p>
 * Annotado com {@link Converter} e {@code autoApply = true}, este conversor
 * é aplicado automaticamente a todos os atributos do tipo {@link Telephone}
 * em entidades JPA, sem a necessidade de anotar cada campo individualmente.
 * </p>
 *
 * <h2>Responsabilidades</h2>
 * <ul>
 *     <li>Converter um {@link Telephone} para {@link String} ao persistir no banco.</li>
 *     <li>Reconstruir um {@link Telephone} a partir da {@link String} armazenada.</li>
 *     <li>Garantir que as validações do próprio value object sejam executadas
 *     durante a conversão.</li>
 * </ul>
 *
 * <p>
 * Valores {@code null} são tratados de forma segura para evitar exceções em
 * operações de leitura e escrita.
 * </p>
 */
@Converter(autoApply = true)
public class TelephoneConverter implements AttributeConverter<Telephone, String> {

    @Override
    public String convertToDatabaseColumn(Telephone telephone) {
        return telephone == null ? null : telephone.value();
    }

    @Override
    public Telephone convertToEntityAttribute(String value) {
        return value == null ? null : new Telephone(value);
    }
}