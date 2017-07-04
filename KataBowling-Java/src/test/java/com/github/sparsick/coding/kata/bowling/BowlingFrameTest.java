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
        BowlingFrame frameUnderTest = new BowlingFrame("11");

        int totalSum = frameUnderTest.totalSum();

        assertThat(totalSum).isEqualTo(2);
    }




}
