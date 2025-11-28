package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.substitutive.booksHub.domain.valueobjects.Telephone;

import java.io.IOException;
/**
 * Serializador personalizado para o Value Object {@link Telephone}.
 * <p>
 * Esta classe define como uma instância de {@link Telephone} deve ser convertida
 * para uma representação textual no JSON durante o processo de serialização
 * realizado pelo Jackson.
 */
public class TelephoneSerializer extends JsonSerializer<Telephone> {

    @Override
    public void serialize(Telephone telephone, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        gen.writeString(telephone.value());
    }
}
