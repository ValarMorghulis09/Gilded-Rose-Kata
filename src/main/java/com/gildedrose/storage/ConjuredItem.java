package com.gildedrose.storage;

import com.gildedrose.item.AbstractItem;
import com.gildedrose.item.Item;

public class ConjuredItem extends AbstractItem {

    /**
     * "Conjured" items degrade in Quality twice as fast as normal items
     *
     * @param item
     */
    public void update(Item item) {
        int decreaseQualityNumberOfTimes = item.sellIn < 0 ? 4 : 2;
        decreaseSellIn(item);
        while (decreaseQualityNumberOfTimes > 0) {
            decreaseQuality(item);
            decreaseQualityNumberOfTimes--;
        }
    }
}
