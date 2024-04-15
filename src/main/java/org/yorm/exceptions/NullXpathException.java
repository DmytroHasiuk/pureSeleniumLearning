package org.yorm.exceptions;

public class NullXpathException extends Exception{


    public NullXpathException() {
        this("Your xpath is null");
    }

    public NullXpathException(String message) {
        super(message);
    }
}
