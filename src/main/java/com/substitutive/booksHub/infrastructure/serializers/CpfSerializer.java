package com.substitutive.booksHub.infrastructure.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.substitutive.booksHub.domain.valueobjects.CPF;

import java.io.IOException;
/**
 * Serializador personalizado para o Value Object {@link CPF}.
 * <p>
 * Esta classe define como uma instância de {@link CPF} deve ser convertida
 * em JSON ao ser enviada em respostas da API. O valor interno do CPF é
 * escrito como uma string simples no JSON.
 */
public class CpfSerializer extends JsonSerializer<CPF> {

    @Override
    public void serialize(CPF cpf, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
        gen.writeString(cpf.value());
    }
}
