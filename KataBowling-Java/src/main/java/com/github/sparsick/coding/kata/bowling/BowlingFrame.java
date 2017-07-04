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
        
        if(roll.equals("/")) {
            return 10-firstRoll;
        }
        
        return roll.equals("-") ? 0 : Integer.parseInt(roll);
    }

    int totalSum() {           
        return simpleTotal() + strikeBonus() + spareBonus();
    }


    void nextFrame(BowlingFrame bowlingFrame) {
        nextBowlingFrame = bowlingFrame;
    }
    
    private int simpleTotal() {
        return firstRoll + secondRoll;
    }
    
    private int strikeBonus() {
        int strikeBonus = 0;
        if(isStrike()) {
            int secondRollOfStrike = nextBowlingFrame.isStrike() ?  nextBowlingFrame.nextBowlingFrame.firstRoll : nextBowlingFrame.secondRoll;
            strikeBonus =  nextBowlingFrame.firstRoll + secondRollOfStrike;
        }
        return strikeBonus;
    }

    private boolean isStrike() {
        return firstRoll == 10;
    }

    private int spareBonus() {
        return isSpare() ? nextBowlingFrame.firstRoll : 0;
    }

    private boolean isSpare() {
        return firstRoll != 10 && simpleTotal() == 10;
    }

}
