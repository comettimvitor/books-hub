package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.substitutive.booksHub.domain.valueobjects.CPF;

import java.io.IOException;

public class CpfDeserializer extends JsonDeserializer<CPF> {

    @Override
    public CPF deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        return new CPF(value);
    }
}

