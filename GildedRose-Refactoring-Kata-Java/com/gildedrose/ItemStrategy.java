package com.gildedrose;

/**
 * @author sparsick
 * @since 29.05.16
 */
public class ItemStrategy {

    public Item updateQualityForAgedBrieItem(Item item) {
        int newQuality = sellInIsPassed(item) ? item.quality + 2 : item.quality + 1;

        if(isQualityGreaterThanFifty(newQuality)) {
            newQuality = 50;
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    public Item updateQualityForSulfurasItem(Item item) {
        return item;
    }

    public Item updateQualityForBackstagePassItem(Item item) {
        int newQuality;

        if(sellInIsPassed(item)) {
            newQuality = 0;
        } else if(sellInIsInFiveOrLessDays(item)) {
            newQuality = item.quality + 3;
        } else if(sellInIsInTenOrLessDays(item)) {
            newQuality = item.quality + 2;
        } else {
            newQuality = item.quality + 1;
        }

        if(isQualityGreaterThanFifty(newQuality)) {
            newQuality = 50;
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    public Item updateQualityForNormalItem(Item item) {
        int newQuality = sellInIsNotPassed(item) ? item.quality -1 : item.quality -2;

        if(isQualityNegative(newQuality)) {
            newQuality = 0;
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    private boolean isQualityNegative(int newQuality) {
        return newQuality < 0;
    }

    private boolean sellInIsNotPassed(Item item) {
        return item.sellIn > -1;
    }

    private boolean sellInIsPassed(Item item) {
        return item.sellIn < 1;
    }

    private boolean sellInIsInTenOrLessDays(Item item) {
        return item.sellIn < 11;
    }

    private boolean sellInIsInFiveOrLessDays(Item item) {
        return item.sellIn < 6;
    }

    private boolean isQualityGreaterThanFifty(int newQuality) {
        return newQuality > 50;
    }




}
