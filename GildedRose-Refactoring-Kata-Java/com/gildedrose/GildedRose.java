package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;

    static Map<String, ItemStrategy> itemStrategyMap = new HashMap<>();

    static {
        itemStrategyMap.put("Aged Brie", new AgedBrieItemStrategy());
        itemStrategyMap.put("Sulfuras, Hand of Ragnaros", new SulfurasItemStrategy());
        itemStrategyMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassItemStrategy());
        itemStrategyMap.put("Conjured", new ConjuredItemStrategy());
    }

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            ItemStrategy itemStrategy = itemStrategyMap.getOrDefault(items[i].name, new NormalItemStrategy());
            items[i] = itemStrategy.updateItem(items[i]);
        }
    }
}
