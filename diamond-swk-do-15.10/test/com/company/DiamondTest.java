package com.company;

import static com.company.Diamond.CRLF;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * @author sparsick
 * @since 21.10.15
 */
public class DiamondTest {

    private Diamond diamond;

    @Before
    public void setUp() {
        diamond = new Diamond();
    }

    @Test
    public void givenAnAAnDiamondOfA() throws Exception {
        String result = diamond.createDiamondFor('A');
        assertThat(result, is("A"));
    }

    @Test
    public void givenAnBABDiamondIsCreated() throws Exception {
        String result = diamond.createDiamondFor('B');
        assertThat(result, is(" A " + CRLF +
                              "B B" + CRLF +
                              " A "));
    }

    @Test
    public void givenAnCACDiamondIsCreated() throws Exception {
        String result = diamond.createDiamondFor('C');
        assertThat(result, is("  A  "+ CRLF +
                              " B B " + CRLF +
                              "C   C" + CRLF +
                              " B B " + CRLF +
                              "  A  "));
    }
    @Test
    public void givenAnDACDiamondIsCreated() throws Exception {
        String result = diamond.createDiamondFor('D');
        assertThat(result, is("   A   "+ CRLF +
                "  B B  " + CRLF +
                " C   C " + CRLF +
                "D     D" + CRLF +
                " C   C " + CRLF +
                "  B B  " + CRLF +
                "   A   "));
    }

}