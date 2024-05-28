package br.com.brandao.help_pets.exceptions;

public class RefugeAlreadyExistsException extends RuntimeException {
    public RefugeAlreadyExistsException(String message) {
        super(message);
    }
}
