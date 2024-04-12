package org.yorm.exceptions;

public class MoreThanOneInfantException extends RuntimeException{

    public MoreThanOneInfantException() {
        this("Only one infant allowed");
    }

    public MoreThanOneInfantException(String message) {
        super(message);
    }
}
