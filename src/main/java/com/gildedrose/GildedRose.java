package com.gildedrose;

import com.gildedrose.item.AbstractItem;
import com.gildedrose.item.Item;
import com.gildedrose.item.ItemFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            AbstractItem currentItem = ItemFactory.getItems(item);
            currentItem.update(item);
        }
    }
}
