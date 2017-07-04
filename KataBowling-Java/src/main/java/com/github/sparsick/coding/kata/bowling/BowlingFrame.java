package com.github.sparsick.coding.kata.bowling;

/**
 *
 * 
 */
class BowlingFrame {
    private int firstRoll;
    private final int secondRoll;

    BowlingFrame(String rolls) {
        firstRoll = rolls.startsWith("-") ? 0 : Integer.parseInt(rolls.substring(0, 1));
        secondRoll = Integer.parseInt(rolls.substring(1, 2));
        
    }

    int totalSum() {
        return firstRoll + secondRoll;
    }

}
