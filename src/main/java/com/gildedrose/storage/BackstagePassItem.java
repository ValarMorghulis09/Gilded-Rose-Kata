package com.gildedrose.storage;

import com.gildedrose.item.AbstractItem;
import com.gildedrose.item.Item;

public class BackstagePassItem extends AbstractItem {

    /**
     * BackstagePassItem like aged brie, increases in Quality as its SellIn value approaches;
     * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less but
     * Quality drops to 0 after the concert
     * @param item
     */
    public void update(Item item) {
        increaseQuality(item,1);
        if (item.sellIn < 11) {
            increaseQuality(item,1);
        }
        if (item.sellIn < 6) {
            increaseQuality(item,1);
        }
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
