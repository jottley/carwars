package net.ottleys.carwars.services;

import java.util.Random;

import org.springframework.stereotype.Service;

import net.ottleys.carwars.exceptions.IllegalDiceArgumentException;
import net.ottleys.carwars.exceptions.IllegalDiceModifierArgumentException;

@Service
public class DiceService {

    private static final int SIDES = 6;
    private static final int MAX_DICE = 10;
    private static final int MIN_DICE = 1;
    private static final int MAX_MODIFIER = 25;
    private static final int MIN_MODIFIER = -25;
    private static final int MIN_VALUE = 1;
    private static final int TWO = 2;

    private Random random = new Random();

    public DiceService() {   
        // This constructor is intentionally empty. Nothing special is needed here.
    }

    /** 
     * A simple dice roll method that returns a random number between 1 and 6.
     * 
     * @return int
     */
    public int roll() {
        return random.nextInt(SIDES) + 1;
    }

    
    /** 
     * A simple dice roll method that returns a random number between 1 and 6 for a specified number of dice.
     * 
     * @param numDice Max number of dice to roll (1-10)
     * @return int
     */
    public int roll(int numDice) throws IllegalDiceArgumentException {
        if (numDice < MIN_DICE || numDice > MAX_DICE) {
            throw new IllegalDiceArgumentException("Number of dice must be between " + MIN_DICE + " and " + MAX_DICE);
        }

        int total = 0;
        for (int i = 0; i < numDice; i++) {
            total += roll();
        }
        return total;
    }

    
    /** 
     * A simple dice roll method that returns a random number between 1 and 6 for a specified number of dice.
     * The total is then modified by a specified modifier. The modifier can be positive or negative.
     * 
     * @param numDice Max number of dice to roll (1-10)
     * @param modifier Modifier to apply to the total (-25 to 25)
     * @return int
     */
    public int roll(int numDice, int modifier) throws IllegalDiceArgumentException, IllegalDiceModifierArgumentException {
        if (numDice < MIN_DICE || numDice > MAX_DICE) {
            throw new IllegalDiceArgumentException("Number of dice must be between " + MIN_DICE + " and " + MAX_DICE);
        }

        if (modifier < MIN_MODIFIER || modifier > MAX_MODIFIER) {
            throw new IllegalDiceModifierArgumentException("Modifier must be between " + MIN_MODIFIER + " and " + MAX_MODIFIER);
        }

        int roll = roll(numDice) + modifier;

        if (roll < MIN_VALUE) {
            roll = MIN_VALUE;
        }

        return roll;
    }


    /** 
     * A simple dice roll method that returns a random number.
     * The rolls are divided by 2 and rounded up.
     * The total will not be less than 1.
     * 
     * @param half True if the rolls should be halved
     * @return int
     */
    public int roll(boolean half){
       if (half){
            double roll = (double) roll() / TWO;
            
           return (int) Math.ceil(roll);
       }

       return roll();
 

    }

}
