package br.com.basis.prova.servico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidacaoException extends RuntimeException {

    public ValidacaoException(final String message) {
        this(message, null);
    }

    public ValidacaoException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
