package net.ottleys.carwars.exceptions;

public class IllegalDiceModifierArgumentException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    public IllegalDiceModifierArgumentException(String message) {
        super(message);
    }

    public IllegalDiceModifierArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

}
