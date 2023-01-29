package br.com.beachtennisbrazil.api.app.exceptions;

public class NotPossibleBorrowMaterialException extends RuntimeException {
    public NotPossibleBorrowMaterialException(String err) {
        super(err);
    }
}