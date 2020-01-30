package br.com.basis.prova.servico.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationExceptionCpf extends Exception {

    public String getMessage(String message) {
        return message;
    }
}
