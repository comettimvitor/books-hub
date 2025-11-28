package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;

import java.io.IOException;
/**
 * Serializador personalizado para o Value Object {@link InternationalStandardBookNumber}.
 * <p>
 * Esta classe define como uma instância de {@link InternationalStandardBookNumber}
 * deve ser convertida em uma String durante o processo de serialização do Jackson.
 */
public class IsbnSerializer extends JsonSerializer<InternationalStandardBookNumber> {
    @Override
    public void serialize(InternationalStandardBookNumber internationalStandardBookNumber, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(internationalStandardBookNumber.value());
    }
}
