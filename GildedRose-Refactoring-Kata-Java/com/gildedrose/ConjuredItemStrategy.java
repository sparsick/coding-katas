package com.gildedrose;

/**
 * @author sparsick
 * @since 29.05.16
 */
public class ConjuredItemStrategy implements ItemStrategy {

    @Override
    public Item updateItem(Item item) {
        int newQuality = sellInIsNotPassed(item) ? item.quality -2 : item.quality -4;

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
}
