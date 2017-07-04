package com.github.sparsick.coding.kata.bowling;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
class Game {
    
    private final List<BowlingFrame> bowlingFrames = new ArrayList<>();

    int roll(String allRolls) {
        fillBowlingFrameList(allRolls);
        
        return calculateTotalSumOfGame();
    }

    private int calculateTotalSumOfGame() {
        return bowlingFrames.subList(0, 10).stream().mapToInt(bowlingFrame -> bowlingFrame.totalSum()).sum();
    }

    private void fillBowlingFrameList(String allRolls) {
        for (int i = 0; i < allRolls.length(); i++) {
            BowlingFrame bowlingFrame = new BowlingFrame(pickRollsForFrame(allRolls, i));
            connectFrameWithLastFrame(bowlingFrame);
            bowlingFrames.add(bowlingFrame);
          
            if(!bowlingFrame.isStrike()) {
                i++;
            }
        }
    }

    private void connectFrameWithLastFrame(BowlingFrame bowlingFrame) {
        if(!bowlingFrames.isEmpty()) {
            BowlingFrame lastFrame = bowlingFrames.remove(bowlingFrames.size()-1);
            lastFrame.nextFrame(bowlingFrame);
            bowlingFrames.add(lastFrame);
        }
    }

    private String pickRollsForFrame(String allRolls, int i) {
        char firstRoll = allRolls.charAt(i);
        String frame = Character.toString(firstRoll);
        if(isNotStrike(firstRoll) && rollIsNotTheLastOne(i, allRolls)) {
            char secondRoll = allRolls.charAt(i + 1);
            frame = frame.concat(Character.toString(secondRoll));
        }
        return frame;
    }

    private boolean rollIsNotTheLastOne(int i, String allRolls) {
        return i < allRolls.length() -1;
    }

    private boolean isNotStrike(char firstRoll) {
        return firstRoll != 'X';
    }

}
