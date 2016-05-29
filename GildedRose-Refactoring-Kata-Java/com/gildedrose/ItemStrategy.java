package com.gildedrose;

/**
 * @author sparsick
 * @since 29.05.16
 */
public class ItemStrategy {

    public Item updateQualityForAgedBrieItem(Item item) {
        return new AgedBrieItemStrategy().updateQuality(item);
    }

    public Item updateQualityForSulfurasItem(Item item) {
        return new SulfurasItemStrategy().updateQuality(item);
    }

    public Item updateQualityForBackstagePassItem(Item item) {
        return new BackstagePassItemStrategy().updateQuality(item);
    }

    public Item updateQualityForConjuredItem(Item item) {
        return new ConjuredItemStrategy().updateQuality(item);
    }

    public Item updateQualityForNormalItem(Item item) {
        return new NormalItemStrategy().updateQuality(item);
    }


}
