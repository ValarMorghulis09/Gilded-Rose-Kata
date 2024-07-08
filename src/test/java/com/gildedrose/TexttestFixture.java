package com.gildedrose;

import com.gildedrose.interfaces.ItemUpdateInterface;
import com.gildedrose.items.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TexttestFixture {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        List<Item> items = new ArrayList<>();

        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 5, 7));
        items.add(new Item("Elixir of the Mongoose", 2, 6));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 8));
        items.add(new Item("Sulfuras, Hand of Ragnaros", -1, 8));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
        items.add(new Item("Conjured Mana Cake", 3, 6));
        Map<String, ItemUpdateInterface> strategies = new HashMap<>();
        strategies.put("Aged Brie", new AgedBrie());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePass());
        strategies.put("Sulfuras, Hand of Ragnaros", new Sulfuras());
        strategies.put("Conjured", new Conjured());
        strategies.put("default", new DefaultItem());
        GildedRose app = new GildedRose(items,strategies);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
