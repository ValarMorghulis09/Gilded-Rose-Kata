package com.gildedrose;

import com.gildedrose.interfaces.ItemUpdateInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GildedRose {
    private final List<Item> items;
    private final Map<String, ItemUpdateInterface> strategies;


    public GildedRose(List<Item> items, Map<String, ItemUpdateInterface> strategies) {
        this.items = items;
        this.strategies = strategies;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdateInterface strategy = strategies.getOrDefault(item.name, strategies.get("Default"));
            strategy.update(item);
        }
    }

    public List<Item> getItems() {
        return items;
    }
}
