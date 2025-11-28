package com.substitutive.booksHub.infrastructure.dtos;

import java.time.Instant;
/**
 * DTO utilizado para representar respostas de erro retornadas pela camada de API.
 *
 * <p>
 * Este objeto é usado pelo {@code GlobalExceptionHandler} para padronizar a forma
 * como erros são enviados ao cliente, incluindo informações relevantes sobre a
 * exceção ocorrida.
 * </p>
 *
 * <h2>Campos</h2>
 * <ul>
 *     <li><b>message</b>: descrição detalhada do erro.</li>
 *     <li><b>error</b>: nome da exceção lançada.</li>
 *     <li><b>status</b>: código HTTP associado ao erro.</li>
 *     <li><b>timestamp</b>: momento em que o erro ocorreu.</li>
 * </ul>
 *
 * <p>
 * É declarado como um {@code record}, garantindo imutabilidade e simplificando
 * a estrutura de dados para respostas de erro.
 * </p>
 */
public record ErrorResponse(
        String message,
        String error,
        int status,
        Instant timestamp
)  {
}
