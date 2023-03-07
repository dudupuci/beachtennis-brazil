package br.com.beachtennisbrazil.api.system.exceptions;

public class CpfAlreadyExistsOnDatabaseException extends RuntimeException {
    public CpfAlreadyExistsOnDatabaseException(String msg) {
        super(msg);
    }
}
