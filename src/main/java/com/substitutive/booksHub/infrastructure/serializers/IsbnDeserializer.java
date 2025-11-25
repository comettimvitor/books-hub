package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;

import java.io.IOException;

public class IsbnDeserializer extends JsonDeserializer<InternationalStandardBookNumber> {
    @Override
    public InternationalStandardBookNumber deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String value = jsonParser.getValueAsString();
        return new InternationalStandardBookNumber(value);
    }
}
