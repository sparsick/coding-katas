package com.github.sparsick.coding.kata.bowling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *
 *
 */
public class BowlingFrameTest {

    @Test
    public void totalSum_failToKnockAll() {
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("1");
        frameUnderTest.roll("1");

        int totalSum = frameUnderTest.totalSum();

        assertThat(totalSum).isEqualTo(2);
    }

    @Test
    public void totalSum_secondFailToKnockAll() {
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("2");
        frameUnderTest.roll("2");

        int totalSum = frameUnderTest.totalSum();

        assertThat(totalSum).isEqualTo(4);
    }

    @Test
    public void totalSum_failToKnockAllWithAMissAsFirstRoll() {
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("-");
        frameUnderTest.roll("1");

        int totalSum = frameUnderTest.totalSum();

        assertThat(totalSum).isEqualTo(1);
    }

    @Test
    public void totalSum_failToKnockAllWithTwoMissedRoll() {
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("-");
        frameUnderTest.roll("-");

        int totalSum = frameUnderTest.totalSum();

        assertThat(totalSum).isEqualTo(0);
    }

    @Test
    public void totalSum_strike() {
        BowlingFrame nextBowlingFrame = new BowlingFrame();
        nextBowlingFrame.roll("1");
        nextBowlingFrame.roll("1");
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("X");
        frameUnderTest.nextFrame(nextBowlingFrame);

        int totalSum = frameUnderTest.totalSum();

        assertThat(totalSum).isEqualTo(12);
    }

    @Test
    public void totalSum_twoStrike() {
        BowlingFrame lastBowlingFrame = new BowlingFrame();
        lastBowlingFrame.roll("1");
        lastBowlingFrame.roll("1");
        BowlingFrame nextFrameWithStrike = new BowlingFrame();
        nextFrameWithStrike.roll("X");
        nextFrameWithStrike.nextFrame(lastBowlingFrame);
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("X");
        frameUnderTest.nextFrame(nextFrameWithStrike);

        int totalSum = frameUnderTest.totalSum();

        assertThat(totalSum).isEqualTo(21);
    }

    @Test
    public void totalSum_spare() {
        BowlingFrame nextBowlingFrame = new BowlingFrame();
        nextBowlingFrame.roll("1");
        nextBowlingFrame.roll("1");
        BowlingFrame frameUnderTest = new BowlingFrame();
        frameUnderTest.roll("3");
        frameUnderTest.roll("/");
        frameUnderTest.nextFrame(nextBowlingFrame);

        int totalSum = frameUnderTest.totalSum();

        assertThat(totalSum).isEqualTo(11);
    }



}
