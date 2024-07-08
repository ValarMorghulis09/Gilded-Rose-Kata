package com.gildedrose.item;

public abstract class AbstractItem {

    protected static final int MAX_QUALITY = 50;
    protected static final int MIN_QUALITY = 0;

    /**
     *
     * @param item
     * @param numberOfTimes The number of times of repeating the increase operation
     */
    protected void increaseQuality(Item item,Integer numberOfTimes) {
        while (numberOfTimes > 0) {
            if (item.quality < MAX_QUALITY) {
                item.quality++;
            }
            numberOfTimes--;
        }
    }

    /**
     *
     * @param item Item
     * @param numberOfTimes The number of times of repeating the decrease operation
     */
    protected void decreaseQuality(Item item,Integer numberOfTimes) {
       while(numberOfTimes > 0){
           if (item.quality > MIN_QUALITY) {
               item.quality--;
           }
           numberOfTimes--;
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
