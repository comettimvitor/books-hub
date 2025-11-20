package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.substitutive.booksHub.domain.valueobjects.Email;

import java.io.IOException;

public class EmailSerializer extends JsonSerializer<Email> {

    @Override
    public void serialize(Email email, JsonGenerator gen, SerializerProvider serializerProvider) throws IOException {
        gen.writeString(email.value());
    }
}