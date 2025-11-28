package com.substitutive.booksHub.infrastructure.modules;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.substitutive.booksHub.domain.valueobjects.CPF;
import com.substitutive.booksHub.domain.valueobjects.Email;
import com.substitutive.booksHub.domain.valueobjects.InternationalStandardBookNumber;
import com.substitutive.booksHub.domain.valueobjects.Telephone;
import com.substitutive.booksHub.infrastructure.serializers.*;
import org.springframework.stereotype.Component;
/**
 * Módulo customizado do Jackson responsável por registrar serializers e
 * deserializers para os value objects do domínio.
 *
 * <p>
 * Esta classe estende {@link SimpleModule} e é registrada automaticamente
 * pelo Spring por meio da anotação {@link Component}. Assim, o Jackson passa a
 * reconhecer automaticamente como converter os value objects para JSON e como
 * reconstruí-los a partir de dados recebidos nas requisições.
 * </p>
 *
 * <h2>Value Objects Suportados</h2>
 * <ul>
 *     <li>{@link CPF}</li>
 *     <li>{@link Email}</li>
 *     <li>{@link Telephone}</li>
 *     <li>{@link InternationalStandardBookNumber}</li>
 * </ul>
 *
 * <h2>Funcionalidade</h2>
 * <p>
 * Para cada value object, este módulo registra:
 * </p>
 * <ul>
 *     <li>Um <b>deserializer</b> personalizado, responsável por transformar
 *         valores JSON em value objects.</li>
 *     <li>Um <b>serializer</b> personalizado, responsável por transformar
 *         value objects em representações JSON válidas.</li>
 * </ul>
 *
 * <p>
 * A utilização de serializers e deserializers específicos garante que:
 * </p>
 * <ul>
 *     <li>As validações internas dos value objects sejam respeitadas.</li>
 *     <li>A representação JSON seja consistente com as regras de negócio.</li>
 *     <li>As APIs aceitem e retornem tipos de domínio ao invés de simples Strings.</li>
 * </ul>
 */
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