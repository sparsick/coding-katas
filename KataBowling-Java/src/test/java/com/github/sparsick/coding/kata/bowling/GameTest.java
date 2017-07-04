package com.github.sparsick.coding.kata.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 * 
 */
public class GameTest {
    
    @Test
    public void roll_twelveStrikes(){
        Game gameUnderTest = new Game();
        
        int totalSum = gameUnderTest.roll("XXXXXXXXXXXX");
        
        assertThat(totalSum).isEqualTo(300);
    }

}
