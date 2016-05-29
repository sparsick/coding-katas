package com.gildedrose;

class GildedRose {
    Item[] items;

    ItemStrategy itemStrategy = new ItemStrategy();

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if("Aged Brie".equals(items[i].name)) {
                items[i] = itemStrategy.updateQualityForAgedBrieItem(items[i]);
            } else if ("Sulfuras, Hand of Ragnaros".equals(items[i].name)) {
                items[i] = itemStrategy.updateQualityForSulfurasItem(items[i]);
            } else if("Backstage passes to a TAFKAL80ETC concert".equals(items[i].name)) {
                items[i] = itemStrategy.updateQualityForBackstagePassItem(items[i]);
            } else {
                items[i] = itemStrategy.updateQualityForNormalItem(items[i]);
            }
        }
    }
}
