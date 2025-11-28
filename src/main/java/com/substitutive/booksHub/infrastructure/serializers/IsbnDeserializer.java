package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;

import java.io.IOException;
/**
 * Desserializador personalizado para o Value Object {@link InternationalStandardBookNumber}.
 * <p>
 * Esta classe define como uma String recebida no JSON deve ser convertida em uma
 * instância do Value Object {@link InternationalStandardBookNumber} durante o
 * processo de desserialização realizado pelo Jackson.
 */
public class IsbnDeserializer extends JsonDeserializer<InternationalStandardBookNumber> {
    @Override
    public InternationalStandardBookNumber deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String value = jsonParser.getValueAsString();
        return new InternationalStandardBookNumber(value);
    }
}
