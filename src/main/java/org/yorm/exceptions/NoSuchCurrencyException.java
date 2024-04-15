package org.yorm.exceptions;

public class NoSuchCurrencyException extends Exception{
    public NoSuchCurrencyException() {
        this("No such currency is present");
    }

    public NoSuchCurrencyException(String message) {
        super(message);
    }
}
