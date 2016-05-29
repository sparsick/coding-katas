package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void checkItemName() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void qualityCannotBeNegative() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void decreaseSellDate() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    public void decreaseQuality() {
        Item[] items = new Item[] { new Item("foo", 0, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void decreaseQualityTwice() {
        Item[] items = new Item[] { new Item("foo", -1, 2) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }


    @Test
    public void decreaseQualityTwiceWithNoNegativeValue() {
        Item[] items = new Item[] { new Item("foo", -1, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }



}
