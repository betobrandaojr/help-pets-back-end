package br.com.brandao.help_pets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Não existe nenhum usuário cadastrado!", value = HttpStatus.NOT_FOUND)
public class NothinUserException extends RuntimeException {
}