package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.interfaces.ItemUpdateInterface;
import org.springframework.stereotype.Component;

@Component("Backstage passes to a TAFKAL80ETC concert")
public class BackstagePass implements ItemUpdateInterface {
    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
            if (item.sellIn < 10 && item.quality < 50) {
                item.quality++;
            }
            if (item.sellIn < 5 && item.quality < 50) {
                item.quality++;
            }
        }
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
