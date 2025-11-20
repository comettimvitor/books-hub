package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.substitutive.booksHub.domain.valueobjects.CPF;

import java.io.IOException;

public class CpfSerializer extends JsonSerializer<CPF> {

    @Override
    public void serialize(CPF cpf, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        gen.writeString(cpf.value());
    }
}
