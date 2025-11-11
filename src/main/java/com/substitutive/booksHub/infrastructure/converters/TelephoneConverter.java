package com.substitutive.booksHub.infrastructure.converters;

import com.substitutive.booksHub.domain.valueobjects.Telephone;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

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