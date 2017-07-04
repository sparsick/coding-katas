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
        secondRoll = isStrike() || rolls.length() == 1 ? 0 : calculatePoints(rolls.substring(1, 2));
        
    }

    private int calculatePoints(String roll) {
        int points;
        switch(roll) {
            case "X":
                points = 10;
                break;
            case "/":
                points = 10 - firstRoll;
                break;
            case "-":
                points = 0;
                break;
            default:
                points = Integer.parseInt(roll);
        }
        
       return points;
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
