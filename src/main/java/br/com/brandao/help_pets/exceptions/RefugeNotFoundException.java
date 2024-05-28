package br.com.brandao.help_pets.exceptions;

public class RefugeNotFoundException extends RuntimeException {
    public RefugeNotFoundException(String message) {
        super(message);
    }
}
