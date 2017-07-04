package com.github.sparsick.coding.kata.bowling;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
class Game {
    
    private List<BowlingFrame> bowlingFrames = new ArrayList<>();
    
    

    int roll(String allRolls) {
        for (int i = 0; i < allRolls.length(); i++) {
           
            char firstRoll = allRolls.charAt(i);
            String frame = Character.toString(firstRoll);
            
            if(firstRoll != 'X' && i < allRolls.length() -1) {
                i++;
                char secondRoll = allRolls.charAt(i);
                frame = frame.concat(Character.toString(secondRoll));
            }
            
            BowlingFrame bowlingFrame = new BowlingFrame(frame);
            
            if(!bowlingFrames.isEmpty()) {
                BowlingFrame lastFrame = bowlingFrames.remove(bowlingFrames.size()-1);
                lastFrame.nextFrame(bowlingFrame);
                bowlingFrames.add(lastFrame);
            }
            
            
            bowlingFrames.add(bowlingFrame);
        }
        
        return bowlingFrames.subList(0, 10).stream().mapToInt(bowlingFrame -> bowlingFrame.totalSum()).sum();
    }

}
