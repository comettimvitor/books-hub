package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.substitutive.booksHub.domain.valueobjects.Email;

import java.io.IOException;
/**
 * Desserializador personalizado para o Value Object {@link Email}.
 * <p>
 * Esta classe define como uma string presente no JSON deve ser convertida
 * em uma instância do Value Object {@link Email} durante o processo de
 * desserialização realizado pelo Jackson.
 */
public class EmailDeserializer extends JsonDeserializer<Email> {

    @Override
    public Email deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        return new Email(value);
    }
}
