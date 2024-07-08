package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GildedRoseApplicationTests {


    @Autowired
    private GildedRose gildedRose;


    @Test
    public void testAgedBrieIncreasesInQuality() {
        List<Item> items = gildedRose.getItems();
        Item agedBrie = items.stream().filter(item -> "Aged Brie".equals(item.name)).findFirst().orElse(null);

        assert agedBrie != null;
        int initialQuality = agedBrie.quality;
        gildedRose.updateQuality();
        assertEquals(initialQuality + 1, agedBrie.quality);
    }


    // Add more tests for different scenarios
}

