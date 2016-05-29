package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;

    ItemStrategy itemStrategy = new ItemStrategy();

    static Map<String, IItemStrategy> itemStrategyMap = new HashMap<>();

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
            IItemStrategy iItemStrategy = itemStrategyMap.getOrDefault(items[i].name, new NormalItemStrategy());
            items[i] = iItemStrategy.updateQuality(items[i]);
        }
    }
}
