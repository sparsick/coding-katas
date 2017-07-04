package com.github.sparsick.coding.kata.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 *
 */
public class GameTest {

    @Test
    public void roll_twelveStrikes() {
        Game gameUnderTest = new Game();

        int totalSum = gameUnderTest.roll("XXXXXXXXXXXX");

        assertThat(totalSum).isEqualTo(300);
    }

    @Test
    public void roll_twentiesRollsWithtenMisses() {
        Game gameUnderTest = new Game();

        int totalSum = gameUnderTest.roll("9-9-9-9-9-9-9-9-9-9-");

        assertThat(totalSum).isEqualTo(90);

    }
    
    @Test
    public void roll_twentyOneRollsWithTenSpares() {
        Game gameUnderTest = new Game();

        int totalSum = gameUnderTest.roll("5/5/5/5/5/5/5/5/5/5/5");

        assertThat(totalSum).isEqualTo(150);

    }

}
