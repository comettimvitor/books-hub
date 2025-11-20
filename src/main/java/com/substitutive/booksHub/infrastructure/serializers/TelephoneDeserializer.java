package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.substitutive.booksHub.domain.valueobjects.Telephone;

import java.io.IOException;

public class TelephoneDeserializer extends JsonDeserializer<Telephone> {

    @Override
    public Telephone deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        return new Telephone(value);
    }
}
