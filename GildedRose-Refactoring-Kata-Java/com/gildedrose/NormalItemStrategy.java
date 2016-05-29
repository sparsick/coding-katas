package com.gildedrose;

/**
 * @author sparsick
 * @since 29.05.16
 */
public class NormalItemStrategy implements ItemStrategy {

    @Override
    public Item updateItem(Item item) {
        int newQuality = sellInIsNotPassed(item) ? item.quality - 1 : item.quality - 2;

        if (isQualityNegative(newQuality)) {
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
