package com.substitutive.booksHub.infrastructure.modules;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.substitutive.booksHub.domain.valueobjects.CPF;
import com.substitutive.booksHub.domain.valueobjects.Email;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import com.substitutive.booksHub.domain.valueobjects.Telephone;
import com.substitutive.booksHub.infrastructure.serializers.*;
import org.springframework.stereotype.Component;

@Component
public class ValueObjectsModule extends SimpleModule {

    public ValueObjectsModule() {
        super("ValueObjectModule", Version.unknownVersion());

        addDeserializer(CPF.class, new CpfDeserializer());
        addSerializer(CPF.class, new CpfSerializer());

        addDeserializer(Email.class, new EmailDeserializer());
        addSerializer(Email.class, new EmailSerializer());

        addDeserializer(Telephone.class, new TelephoneDeserializer());
        addSerializer(Telephone.class, new TelephoneSerializer());

        addDeserializer(InternationalStandardBookNumber.class, new IsbnDeserializer());
        addSerializer(InternationalStandardBookNumber.class, new IsbnSerializer());
    }
}