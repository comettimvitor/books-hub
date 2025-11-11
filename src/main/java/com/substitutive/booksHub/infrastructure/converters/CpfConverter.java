package com.substitutive.booksHub.infrastructure.converters;

import com.substitutive.booksHub.domain.valueobjects.CPF;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

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
