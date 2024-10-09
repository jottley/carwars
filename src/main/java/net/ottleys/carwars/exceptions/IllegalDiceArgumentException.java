package net.ottleys.carwars.exceptions;

public class IllegalDiceArgumentException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public IllegalDiceArgumentException(String message) {
        super(message);
    }

    public IllegalDiceArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

}
