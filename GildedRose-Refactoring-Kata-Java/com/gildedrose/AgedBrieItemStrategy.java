package com.gildedrose;

/**
 * @author sparsick
 * @since 29.05.16
 */
public class AgedBrieItemStrategy implements IItemStrategy{

    @Override
    public Item updateQuality(Item item) {
        int newQuality = sellInIsPassed(item) ? item.quality + 2 : item.quality + 1;

        if(isQualityGreaterThanFifty(newQuality)) {
            newQuality = 50;
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    private boolean sellInIsPassed(Item item) {
        return item.sellIn < 1;
    }

    private boolean isQualityGreaterThanFifty(int newQuality) {
        return newQuality > 50;
    }
}
