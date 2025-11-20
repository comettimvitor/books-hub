package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.substitutive.booksHub.domain.valueobjects.Email;

import java.io.IOException;

public class EmailDeserializer extends JsonDeserializer<Email> {

    @Override
    public Email deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        return new Email(value);
    }
}
