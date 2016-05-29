package com.gildedrose;

/**
 * @author sparsick
 * @since 29.05.16
 */
public class BackstagePassItemStrategy implements ItemStrategy {

    @Override
    public Item updateQuality(Item item) {
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
