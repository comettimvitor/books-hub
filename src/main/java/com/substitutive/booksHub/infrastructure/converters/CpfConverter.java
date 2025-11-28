package com.substitutive.booksHub.infrastructure.converters;

import com.substitutive.booksHub.domain.valueobjects.CPF;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
/**
 * Converter JPA responsável por mapear o value object {@link CPF} para sua
 * representação em coluna do banco de dados e vice-versa.
 *
 * <p>Este conversor utiliza a anotação {@link Converter} com o parâmetro
 * {@code autoApply = true}, o que significa que ele será automaticamente
 * aplicado para todos os atributos do tipo {@link CPF} nas entidades JPA,
 * sem necessidade de anotação adicional.</p>
 *
 * <h2>Funcionalidade</h2>
 * <ul>
 *     <li>Converte um {@link CPF} para {@link String} ao persistir no banco.</li>
 *     <li>Converte uma {@link String} para {@link CPF} ao ler do banco.</li>
 *     <li>Garante que o value object seja reconstruído corretamente,
 *     aplicando suas validações internas.</li>
 * </ul>
 *
 * <p>Caso o valor seja {@code null}, nenhuma conversão é aplicada.</p>
 *
 * @see CPF
 * @see AttributeConverter
 */
@Converter(autoApply = true)
public class CpfConverter implements AttributeConverter<CPF, String> {

    @Override
    public String convertToDatabaseColumn(CPF cpf) {
        return cpf == null ? null : cpf.value();
    }

    @Override
    public CPF convertToEntityAttribute(String value) {
        return value == null ? null : new CPF(value);
    }
}
