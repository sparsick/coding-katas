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
        secondRoll = firstRoll == 10 ? 0 : calculatePoints(rolls.substring(1, 2));
        
    }

    private int calculatePoints(String roll) throws NumberFormatException {
        if(roll.equals("X")) {
            return 10;
        }
        return roll.equals("-") ? 0 : Integer.parseInt(roll);
    }

    int totalSum() {
        int simpleTotal = firstRoll + secondRoll;
        if(firstRoll == 10) {
            simpleTotal += nextBowlingFrame.firstRoll + nextBowlingFrame.secondRoll;
        }
        return simpleTotal;
    }

    void nextFrame(BowlingFrame bowlingFrame) {
        nextBowlingFrame = bowlingFrame;
    }

}
