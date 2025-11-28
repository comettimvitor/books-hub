package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.substitutive.booksHub.domain.valueobjects.Telephone;

import java.io.IOException;
/**
 * Desserializador personalizado para o Value Object {@link Telephone}.
 * <p>
 * Esta classe define como uma String presente no JSON deve ser convertida
 * em uma instância de {@link Telephone} durante o processo de desserialização
 * realizado pelo Jackson.
 */
public class TelephoneDeserializer extends JsonDeserializer<Telephone> {

    @Override
    public Telephone deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        return new Telephone(value);
    }
}
