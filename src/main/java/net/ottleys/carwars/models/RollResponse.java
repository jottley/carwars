package net.ottleys.carwars.models;

public class RollResponse {
    private int result;
    private int numDice;
    private int modifier;
    private boolean half;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getNumDice() {
        return numDice;
    }

    public void setNumDice(int numDice) {
        this.numDice = numDice;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public boolean isHalf() {
        return half;
    }

    public void setHalf(boolean half) {
        this.half = half;
    }

    public RollResponse(int result) {
        this.result = result;
        numDice = 1;
        modifier = 0;
        half = false;
    }

    public RollResponse(int result, int numDice) {
        this.result = result;
        this.numDice = numDice;
        modifier = 0;
        half = false;
    }

    public RollResponse(int result, boolean half) {
        this.result = result;
        this.numDice = 1;
        modifier = 0;
        this.half = half;
    }

    public RollResponse(int result, int numDice, int modifier) {
        this.result = result;
        this.numDice = numDice;
        this.modifier = modifier;
        half = false;
    }

    public RollResponse(int result, int numDice, int modifier, boolean half) {
        this.result = result;
        this.numDice = numDice;
        this.modifier = modifier;
        this.half = half;
    }

}