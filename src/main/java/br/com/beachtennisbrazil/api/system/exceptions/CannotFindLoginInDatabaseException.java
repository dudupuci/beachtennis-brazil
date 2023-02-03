package br.com.beachtennisbrazil.api.system.exceptions;

public class CannotFindLoginInDatabaseException extends RuntimeException {
    public CannotFindLoginInDatabaseException(String msg) {
        super(msg);
    }
}
