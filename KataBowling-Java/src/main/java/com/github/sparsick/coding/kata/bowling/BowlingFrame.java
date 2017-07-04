package com.github.sparsick.coding.kata.bowling;

/**
 *
 * 
 */
class BowlingFrame {
    private int firstRoll;
    private final int secondRoll;

    BowlingFrame(String rolls) {
        firstRoll = calculatePoints(rolls.substring(0, 1));
        secondRoll = calculatePoints(rolls.substring(1, 2));
        
    }

    private static int calculatePoints(String substring) throws NumberFormatException {
        return substring.equals("-") ? 0 : Integer.parseInt(substring);
    }

    int totalSum() {
        return firstRoll + secondRoll;
    }

}
