package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.interfaces.ItemUpdateInterface;
import org.springframework.stereotype.Component;

@Component("Sulfuras, Hand of Ragnaros")
public class Sulfuras implements ItemUpdateInterface {
    @Override
    public void update(Item item) {
        // Sulfuras doesn't change
    }
}
