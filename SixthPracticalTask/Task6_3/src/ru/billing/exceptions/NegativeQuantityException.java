package ru.billing.exceptions;

public class NegativeQuantityException extends Exception {
    public NegativeQuantityException(String message) {
        super(message);
    }
}