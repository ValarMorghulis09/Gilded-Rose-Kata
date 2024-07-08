package com.gildedrose.storage;

import com.gildedrose.item.AbstractItem;
import com.gildedrose.item.Item;

public class ConjuredItem extends AbstractItem {

    /**
     * "Conjured" items degrade in Quality twice as fast as normal items
     * @param item
     */
    public void update(Item item) {
        decreaseQuality(item,2);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            decreaseQuality(item,2);
        }
    }
}
