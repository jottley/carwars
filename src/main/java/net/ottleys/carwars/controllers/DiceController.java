package net.ottleys.carwars.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ottleys.carwars.models.RollResponse;
import net.ottleys.carwars.services.DiceService;


@RestController
public class DiceController {

    private DiceService diceService;

    public DiceController(DiceService diceService) {
        this.diceService = diceService; 
    }

    private static final int DEFAULT_NUM_DICE = 1;


    @GetMapping("dice/roll")
    public RollResponse roll(@RequestParam(required = false) Boolean half) {
        if (half != null && half) {
            return new RollResponse(diceService.roll(half), half);
        }

        return new RollResponse(diceService.roll());
    }

    @GetMapping("dice/roll/{numDice}")
    public RollResponse roll(@PathVariable int numDice) {
        return new RollResponse(diceService.roll(numDice), numDice);
    }

    @GetMapping("dice/roll/modifier/{modifier}")
    public RollResponse rollWithModifier(@PathVariable int modifier) {
        return new RollResponse(diceService.roll(DEFAULT_NUM_DICE, modifier), DEFAULT_NUM_DICE, modifier);
    }

    @GetMapping("dice/roll/{numDice}/modifier/{modifier}")
    public RollResponse roll(@PathVariable int numDice, @PathVariable int modifier) {
        return new RollResponse(diceService.roll(numDice, modifier), numDice, modifier);
    }

}
