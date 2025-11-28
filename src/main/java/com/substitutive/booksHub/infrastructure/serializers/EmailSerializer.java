package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.substitutive.booksHub.domain.valueobjects.Email;

import java.io.IOException;

/**
 * Serializador personalizado para o Value Object {@link Email}.
 * <p>
 * Esta classe define como uma instância de {@link Email} deve ser convertida
 * para JSON durante o processo de serialização realizado pelo Jackson.
 */
public class EmailSerializer extends JsonSerializer<Email> {

    @Override
    public void serialize(Email email, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeString(email.value());
    }
}