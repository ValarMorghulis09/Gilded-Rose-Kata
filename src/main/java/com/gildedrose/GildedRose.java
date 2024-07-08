package com.gildedrose;

import com.gildedrose.item.AbstractItem;
import com.gildedrose.item.Item;
import com.gildedrose.item.ItemFactory;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    /**
     * This function is used to update the items we have in our storage on daily basis
     */
    public void updateQuality() {
        for (Item item : items) {
            AbstractItem currentItem = ItemFactory.getItems(item);
            currentItem.update(item);
        }
    }
}
