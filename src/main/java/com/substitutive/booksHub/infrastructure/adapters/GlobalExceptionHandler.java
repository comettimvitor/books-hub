package com.substitutive.booksHub.infrastructure.adapters;

import com.substitutive.booksHub.domain.exceptions.DomainException;
import com.substitutive.booksHub.infrastructure.dtos.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
/**
 * GlobalExceptionHandler é um componente responsável por capturar e tratar exceções
 * lançadas pela camada de aplicação. Ele utiliza a anotação {@link ControllerAdvice}
 * para atuar de forma global sobre todos os controllers da aplicação.
 *
 * <p>Este handler intercepta exceções do tipo {@link RuntimeException}. Caso a exceção
 * implementa a interface {@link DomainException}, o método extrai o código HTTP definido
 * na própria exceção e retorna um {@link ResponseEntity} contendo um {@link ErrorResponse}
 * padronizado.</p>
 *
 * <p>Se a exceção capturada não for uma {@link DomainException}, ela é relançada
 * para ser tratada pelo mecanismo padrão do Spring, resultando normalmente em um erro 500.</p>
 *
 * <h2>Responsabilidades:</h2>
 * <ul>
 *     <li>Centralizar o tratamento de erros de domínio.</li>
 *     <li>Construir respostas padronizadas com mensagem, tipo da exceção, status HTTP e timestamp.</li>
 *     <li>Delegar para o Spring o tratamento de exceções não previstas.</li>
 * </ul>
 *
 * <h2>Exemplo de retorno em caso de DomainException:</h2>
 * <pre>
 * {
 *   "message": "Livro não disponível",
 *   "error": "BookNotAvailableException",
 *   "status": 400,
 *   "timestamp": "2025-11-27T22:14:00Z"
 * }
 * </pre>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleDomain(RuntimeException ex) {

        if (ex instanceof DomainException domainException) {
            int status = domainException.getHttpStatus();

            return ResponseEntity
                    .status(status)
                    .body(new ErrorResponse(
                            ex.getMessage(),
                            ex.getClass().getSimpleName(),
                            status,
                            Instant.now()
                    ));
        }

        throw ex;
    }
}
