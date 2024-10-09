package net.ottleys.carwars.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import net.ottleys.carwars.models.RollResponse;
import net.ottleys.carwars.services.DiceService;

@ExtendWith(MockitoExtension.class)
class DiceControllerTest {

    private static final int DEFAULT_NUM_DICE = 1;
    private static final int DEFAULT_MODIFIER = 0;

    @Mock
    private DiceService diceService;

    private DiceController diceController;

    @BeforeEach
    public void setUp() {
        diceController = new DiceController(diceService);
    }

    @Test
    void testRollDefault() {
        int rollValue = 3;
        when(diceService.roll()).thenReturn(rollValue);

        RollResponse response = diceController.roll(null);

        assertEquals(rollValue, response.getResult());
        assertEquals(DEFAULT_NUM_DICE, response.getNumDice());
        assertEquals(DEFAULT_MODIFIER, response.getModifier());
    }

    @Test
    void testRollHalf() {
        int rollValue = 5;
        when(diceService.roll(true)).thenReturn(rollValue);

        RollResponse response = diceController.roll(true);

        assertEquals(rollValue, response.getResult());
        assertEquals(DEFAULT_NUM_DICE, response.getNumDice());
        assertEquals(true, response.isHalf());
        assertEquals(DEFAULT_MODIFIER, response.getModifier());
    }

    @Test
    void testRollSpecificDice() {
        int numDice = 4;
        int rollValue = 12;
        when(diceService.roll(numDice)).thenReturn(rollValue);

        RollResponse response = diceController.roll(numDice);

        assertEquals(rollValue, response.getResult());
        assertEquals(numDice, response.getNumDice());
        assertEquals(DEFAULT_MODIFIER, response.getModifier());
    }

    @Test
    void testRollWithModifier() {
        int numDice = 2;
        int modifier = -1;
        int rollValue = 8;
        when(diceService.roll(numDice, modifier)).thenReturn(rollValue);

        RollResponse response = diceController.roll(numDice, modifier);

        assertEquals(rollValue, response.getResult());
        assertEquals(numDice, response.getNumDice());
        assertEquals(modifier, response.getModifier());
    }
}