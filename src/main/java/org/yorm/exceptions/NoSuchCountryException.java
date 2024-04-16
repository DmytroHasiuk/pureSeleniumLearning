package org.yorm.exceptions;

public class NoSuchCountryException extends Exception{

    public NoSuchCountryException() {
        this("No such country in autocomplete");
    }

    public NoSuchCountryException(String message) {
        super(message);
    }
}
