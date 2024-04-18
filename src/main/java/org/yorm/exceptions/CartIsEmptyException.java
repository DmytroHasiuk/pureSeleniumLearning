package org.yorm.exceptions;

public class CartIsEmptyException extends Exception{

    public CartIsEmptyException() {
        this("Cart is empty");
    }

    public CartIsEmptyException(String message) {
        super(message);
    }
}
