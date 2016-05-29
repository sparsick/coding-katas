package com.gildedrose;

/**
 * @author sparsick
 * @since 29.05.16
 */
public class ItemStrategy {

    public Item updateQualityForAgedBrieItem(Item item) {
        int newQuality;

        if(item.sellIn < 1 ) {
            newQuality = item.quality + 2;
        } else {
            newQuality = item.quality + 1;
        }

        if(newQuality > 50) {
            newQuality = 50;
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }

    public Item updateQualityForSulfurasItem(Item item) {
        return item;
    }

    public Item updateQualityForBackstagePassItem(Item item) {
        int newQuality;

        if(item.sellIn < 1 ) {
            newQuality = item.quality + 2;
        } else {
            newQuality = item.quality + 1;
        }

        if(newQuality > 50) {
            newQuality = 50;
        }

        return new Item(item.name, item.sellIn - 1, newQuality);
    }


}
