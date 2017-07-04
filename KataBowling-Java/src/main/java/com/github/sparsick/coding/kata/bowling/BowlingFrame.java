package com.github.sparsick.coding.kata.bowling;

/**
 *
 * 
 */
class BowlingFrame {
    private int firstRoll;
    private final int secondRoll;
    private BowlingFrame nextBowlingFrame;

    BowlingFrame(String rolls) {
        firstRoll = calculatePoints(rolls.substring(0, 1));
        secondRoll = isStrike() ? 0 : calculatePoints(rolls.substring(1, 2));
        
    }

    private int calculatePoints(String roll) throws NumberFormatException {
        if(roll.equals("X")) {
            return 10;
        }
        return roll.equals("-") ? 0 : Integer.parseInt(roll);
    }

    int totalSum() {
        return simpleTotal() + strikeBonus();
    }

    private int strikeBonus() {
        if(isStrike()) {
            return nextBowlingFrame.firstRoll + (nextBowlingFrame.isStrike() ?  nextBowlingFrame.nextBowlingFrame.firstRoll : nextBowlingFrame.secondRoll);
        }
        return 0;
    }

    void nextFrame(BowlingFrame bowlingFrame) {
        nextBowlingFrame = bowlingFrame;
    }
    
    private int simpleTotal() {
        return firstRoll + secondRoll;
    }

    private boolean isStrike() {
        return firstRoll == 10;
    }

}
