package com.gildedrose.item;

import com.gildedrose.storage.*;

import java.util.HashMap;
import java.util.Map;

public class ItemFactory {

    private static final Map<String, AbstractItem> items = new HashMap<>();
    static {
        items.put("Aged Brie", new AgedBrieItem());
        items.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassItem());
        items.put("Sulfuras, Hand of Ragnaros", new SulfurasItem());
        items.put("Conjured", new ConjuredItem());
    }

    /**
     * Get item by name and if it's not available it will return the Default Item
     * @param item
     * @return
     */
    public static AbstractItem getItems(Item item) {
        return items.getOrDefault(item.name, new DefaultItem());
    }
}
