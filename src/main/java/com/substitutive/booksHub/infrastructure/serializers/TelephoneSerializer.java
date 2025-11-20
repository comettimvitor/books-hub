package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.substitutive.booksHub.domain.valueobjects.Telephone;

import java.io.IOException;

public class TelephoneSerializer extends JsonSerializer<Telephone> {

    @Override
    public void serialize(Telephone telephone, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        gen.writeString(telephone.value());
    }
}
