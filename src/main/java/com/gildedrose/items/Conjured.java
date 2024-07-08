package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.interfaces.ItemUpdateInterface;
import org.springframework.stereotype.Component;

@Component("Conjured")
public class Conjured implements ItemUpdateInterface {
    @Override
    public void update(Item item) {
        item.sellIn--;
        if (item.quality > 0) {
            item.quality -= 2;
        }
        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 2;
        }
    }
}
