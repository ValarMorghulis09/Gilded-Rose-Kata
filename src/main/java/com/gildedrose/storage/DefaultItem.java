package com.gildedrose.storage;

import com.gildedrose.item.AbstractItem;
import com.gildedrose.item.Item;

public class DefaultItem  extends AbstractItem {

    /**
     *
     * @param item
     */
    public void update(Item item) {
        decreaseQuality(item,1);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            decreaseQuality(item,1);
        }
    }
}
