package net.ottleys.carwars.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import net.ottleys.carwars.exceptions.IllegalDiceArgumentException;
import net.ottleys.carwars.exceptions.IllegalDiceModifierArgumentException;

class DiceServiceTest {

    private DiceService diceService;

    @BeforeEach
    public void setUp() {
        diceService = new DiceService();
    }
    
    @Test
    void testRoll() {
        int result = diceService.roll();
        assertTrue(result >= 1 && result <= 6, "Result should be between 1 and 6");
    }

    @Test
    void testRollMultipleDice() {
        int numDice = 3;
        int result = diceService.roll(numDice);
        assertTrue(result >= numDice && result <= numDice * 6, "Result should be between " + numDice + " and " + (numDice * 6));
    }
    
    @Test
    void testRollWithModifier() {
        int numDice = 3;
        int modifier = 2;
        int result = diceService.roll(numDice, modifier);
        assertTrue(result >= numDice + modifier && result <= numDice * 6 + modifier, "Result should be between " + (numDice + modifier) + " and " + (numDice * 6 + modifier));
    }

    @Test
    void testRollWithNegativeModifier() {
        int numDice = 3;
        int modifier = -2;
        int result = diceService.roll(numDice, modifier);
        assertTrue(result >= 1 && result <= numDice * 6 + modifier, "Result should be between 1 and " + (numDice * 6 + modifier));
    }

    @Test
    void testRollWithModifierBelowMinimum() {
        int numDice = 3;
        int modifier = -30;
        assertThrows(IllegalDiceModifierArgumentException.class, () -> {
            diceService.roll(numDice, modifier);
        });
    }

    @Test
    void testRollWithInvalidNumDice() {
        assertThrows(IllegalDiceArgumentException.class, () -> {
            diceService.roll(0);
        });
        assertThrows(IllegalDiceArgumentException.class, () -> {
            diceService.roll(11);
        });
    }

    @Test
    void testRollWithInvalidModifier() {
        assertThrows(IllegalDiceModifierArgumentException.class, () -> {
            diceService.roll(3, -30);
        });
        assertThrows(IllegalDiceModifierArgumentException.class, () -> {
            diceService.roll(3, 30);
        });
    }

    @Test
    void testRollWithHalf() {
        int result = diceService.roll(true);
        assertTrue(result >= 1 && result <= 3, "Result should be between 1 and 3");
    }

    @Test
    void testRollWithoutHalf() {
        int result = diceService.roll(false);
        assertTrue(result >= 1 && result <= 6, "Result should be between 1 and 6");
    }
}