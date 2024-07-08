package com.gildedrose.storage;

import com.gildedrose.item.AbstractItem;
import com.gildedrose.item.Item;


public class AgedBrieItem extends AbstractItem {

    /**
     *  AgedBrie increases in quality the older it gets for ex:
     *  AgedBrie sellIn is == 5 it increases by 1 but when it's less than 0 it will increase by 2
     * @param item
     */
    public void update(Item item) {
        increaseQuality(item,1);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            increaseQuality(item,1);
        }
    }
}
