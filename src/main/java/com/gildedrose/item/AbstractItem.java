package com.gildedrose.item;

public abstract class AbstractItem {

    protected static final int MAX_QUALITY = 50;
    protected static final int MIN_QUALITY = 0;

    /**
     *
     * @param item Item
     */
    protected void increaseQuality(Item item) {
        if(item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    /**
     *
     * @param item Item
     */
    protected void decreaseQuality(Item item) {
        if(item.quality > MIN_QUALITY) {
            item.quality--;
        }
    }

    protected void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    /**
     *  Update item according to every implementation
     * @param item
     */
    public void update(Item item) {

    }
}
