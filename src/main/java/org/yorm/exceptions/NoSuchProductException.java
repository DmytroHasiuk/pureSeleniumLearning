package org.yorm.exceptions;

public class NoSuchProductException extends Exception{

    public NoSuchProductException() {
        this("No such product on the page");
    }

    public NoSuchProductException(String message) {
        super(message);
    }
}
