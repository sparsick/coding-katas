package com.github.sparsick.coding.kata.bowling;

/**
 *
 *
 */
class BowlingFrame {

    private Integer firstRoll;
    private Integer secondRoll;
    private BowlingFrame nextBowlingFrame;

    BowlingFrame() {
    }

    private int calculatePoints(String roll) {
        int points;
        switch (roll) {
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

    void roll(String roll) {
        if(firstRoll == null) {
            firstRoll = calculatePoints(roll);
            secondRoll = isStrike() ? 0 : null;
        } else {
            secondRoll = calculatePoints(roll);
        }
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
        if (isStrike()) {
            int secondRollOfStrike = nextBowlingFrame.isStrike() ? nextBowlingFrame.nextBowlingFrame.firstRoll : nextBowlingFrame.secondRoll;
            strikeBonus = nextBowlingFrame.firstRoll + secondRollOfStrike;
        }
        return strikeBonus;
    }

    boolean isStrike() {
        return firstRoll == 10;
    }

    private int spareBonus() {
        return isSpare() ? nextBowlingFrame.firstRoll : 0;
    }

    private boolean isSpare() {
        return firstRoll != 10 && simpleTotal() == 10;
    }

}
