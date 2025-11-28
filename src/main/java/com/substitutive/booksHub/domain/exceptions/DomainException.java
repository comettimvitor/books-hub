package com.substitutive.booksHub.domain.exceptions;
/**
 * Interface base para exceções de domínio do sistema.
 *
 * <p>
 * Esta interface permite padronizar o comportamento das exceções que representam
 * violações de regras de negócio dentro do domínio da aplicação.
 * </p>
 *
 * <p>
 * Cada exceção de domínio deve implementar este contrato para informar o código
 * de status HTTP apropriado que será retornado pela camada de API ou manipuladores
 * globais de exceção.
 * </p>
 *
 * <p>Exemplo de uso:</p>
 * <pre>{@code
 * public class BookNotAvailableException extends RuntimeException implements DomainException {
 *     @Override
 *     public int getHttpStatus() {
 *         return HttpStatus.BAD_REQUEST.value();
 *     }
 * }
 * }</pre>
 */
public interface DomainException {
    int getHttpStatus();
}
