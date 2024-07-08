package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.interfaces.ItemUpdateInterface;
import org.springframework.stereotype.Component;

@Component("Aged Brie")
public class AgedBrie implements ItemUpdateInterface {
    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.quality < 50) {
            item.quality++;
        }
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++;
        }
    }
}
