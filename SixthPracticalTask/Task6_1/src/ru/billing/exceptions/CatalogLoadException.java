package ru.billing.exceptions;

public class CatalogLoadException extends Exception {
    public CatalogLoadException(String message, ItemAlreadyExistsException e) {
        super(message);
    }
}