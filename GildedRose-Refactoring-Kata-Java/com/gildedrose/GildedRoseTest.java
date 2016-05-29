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

    @Test
    public void increaseQualityForAgedBrieItem() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void qualityCannotBeGreaterThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void increaseQualityTwicedForAgedBrieItemBecauseSellInIsPassed() {
        Item[] items = new Item[] { new Item("Aged Brie", -2, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void increaseQualityTwicedForAgedBrieItemBecauseSellInIs0() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void qualityIncreasedTwiceCannotBeGreaterThan50() {
        Item[] items = new Item[] { new Item("Aged Brie", -2, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfurasItemNeverBeSold() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(2, app.items[0].sellIn);
    }

    @Test
    public void sulfurasItemNeverDecreaseQuality() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void checkQualityForBackstagePasses11Daysleft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void checkQualityForBackstagePasses10Daysleft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void checkQualityCannotBeGreaterThan50ForBackstagePasses10Daysleft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void checkQualityForBackstagePasses5Daysleft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void checkQualityCannotBeGreaterThan50ForBackstagePasses5Daysleft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 50) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void checkQualityForBackstagePasses0Daysleft() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void checkQualityForBackstagePassesAfterConcert() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(0, app.items[0].quality);
    }





}
