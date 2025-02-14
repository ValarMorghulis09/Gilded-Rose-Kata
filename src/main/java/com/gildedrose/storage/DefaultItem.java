package com.gildedrose.storage;

import com.gildedrose.item.AbstractItem;
import com.gildedrose.item.Item;

public class DefaultItem  extends AbstractItem {

    /**
     *
     * @param item
     */
    public void update(Item item) {
        int decreaseQualityNumberOfTimes = item.sellIn < 0 ? 2 : 1;
        decreaseSellIn(item);
        while (decreaseQualityNumberOfTimes > 0) {
            decreaseQuality(item);
            decreaseQualityNumberOfTimes--;
        }
    }
}
