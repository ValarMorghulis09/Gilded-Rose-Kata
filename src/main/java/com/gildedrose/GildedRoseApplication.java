package com.gildedrose;

import com.gildedrose.interfaces.ItemUpdateInterface;
import com.gildedrose.items.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class GildedRoseApplication {
    public static void main(String[] args) {
        SpringApplication.run(GildedRoseApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(GildedRose gildedRose) {
        return args -> {
            gildedRose.updateQuality();
            gildedRose.getItems().forEach(System.out::println);
        };
    }

    @Bean
    public List<Item> items() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Conjured", 3, 6));
        items.add(new Item("Regular Item", 5, 7));
        return items;
    }

    @Bean
    public Map<String, ItemUpdateInterface> strategies(
        AgedBrie agedBrie,
        BackstagePass backstagePass,
        Sulfuras sulfuras,
        DefaultItem defaultStrategy,
        Conjured conjured) {
        Map<String, ItemUpdateInterface> strategies = new HashMap<>();
        strategies.put("Aged Brie", agedBrie);
        strategies.put("Backstage passes to a TAFKAL80ETC concert", backstagePass);
        strategies.put("Sulfuras, Hand of Ragnaros", sulfuras);
        strategies.put("Conjured", conjured);
        strategies.put("default", defaultStrategy);
        return strategies;
    }
}
