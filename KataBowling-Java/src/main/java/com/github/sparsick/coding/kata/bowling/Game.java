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
            BowlingFrame bowlingFrame = new BowlingFrame();
            
            char firstRoll = allRolls.charAt(i);
            bowlingFrame.roll(Character.toString(firstRoll));
            
            if(!bowlingFrame.isStrike() && rollIsNotTheLastOne(i, allRolls)) {
                char secondRoll = allRolls.charAt(i + 1);
                bowlingFrame.roll(Character.toString(secondRoll));
                
            }
            
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

    private boolean rollIsNotTheLastOne(int i, String allRolls) {
        return i < allRolls.length() -1;
    }


}
