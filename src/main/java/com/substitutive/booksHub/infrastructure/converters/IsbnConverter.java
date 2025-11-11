package com.substitutive.booksHub.infrastructure.converters;

import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

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