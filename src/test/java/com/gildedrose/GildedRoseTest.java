package com.gildedrose;

import com.gildedrose.item.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void should_returnZero_when_qualityIsZero() {
        Item[] items = new Item[] { new Item("just item", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);

    }


    @Test
    void should_DecreaseSellInAndQualityOfAnItem_when_OneSellInDateHasPassed() {
        Item[] items = new Item[] { new Item("item", 10, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(44, app.items[0].quality);
    }
    @Test
    void should_DecreaseQualityTwiceAsFast_when_SellInDateHasPassed() {
        Item[] items = new Item[] { new Item("item", -1, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(43, app.items[0].quality);
    }
    @Test
    void should_QualityNeverExceed50_when_AgedBrieSellInDatePasses() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    @Test
    void should_IncreaseQualityByOneValue_when_AgedBrieSellInDecrease() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(46, app.items[0].quality);
    }

    @Test
    void should_QualityAndSellInStaysTheSame_when_SulfurasSellInDateDecreases(){
        Item[] items = new Item[] {new Item("Sulfuras, Hand of Ragnaros", 10, 45) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
        assertEquals(45, app.items[0].quality);
    }


    @ParameterizedTest()
    @ValueSource(ints = {10,9,8,7,6})
    void should_QualityIncreaseBy2_when_BackstagePassesSellInDateDecreasesLessThanOrEqual10Days(int number){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",number,10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(number -1, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @ParameterizedTest()
    @ValueSource(ints = {5,4,3,2,1})
    void should_QualityIncreaseBy3_when_BackstagePassesSellInDateDecreasesLessThanOrEqual5Days(int number){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",number,10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(number - 1, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void should_QualityIsDroppedToZero_when_BackstagePassesSellInDateDecreaseAfterConcert(){
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert",0,10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void should_QualityDropTwice_when_ConjuredSellsInDateDecrease(){
        Item[] items = new Item[]{new Item("Conjured",10,10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }

}
