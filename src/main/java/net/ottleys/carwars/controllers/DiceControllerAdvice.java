package net.ottleys.carwars.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import net.ottleys.carwars.exceptions.IllegalDiceArgumentException;
import net.ottleys.carwars.exceptions.IllegalDiceModifierArgumentException;
import net.ottleys.carwars.models.ErrorResponse;

@RestControllerAdvice
public class DiceControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(DiceControllerAdvice.class);

    @ExceptionHandler(IllegalDiceArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalDiceArgumentException(IllegalDiceArgumentException ex, HandlerMethod handlerMethod) {
        log.debug(ex.getMessage());
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

    @ExceptionHandler(IllegalDiceModifierArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalDiceModifierArgumentException(IllegalDiceModifierArgumentException ex) {
        log.debug(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()));
    }

}
