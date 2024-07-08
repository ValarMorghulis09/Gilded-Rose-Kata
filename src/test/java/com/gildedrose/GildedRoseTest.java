package com.gildedrose;

import com.gildedrose.item.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

   private static Item[] fetchItemsWithZeroQuantity(){
        return new Item[]{
            new Item("Conjured", 10, 0),
            new Item("Sulfuras, Hand of Ragnaros", 20, 0),
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
            new Item("Default",1,0) };
    }

    private static Item[] fetchItemsWithQuantityAlwaysMoreThanZero(){
        return new Item[]{
            new Item("Aged Brie", 10, 2),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 1)
        };
    }

    @Test
    void checkItemToStringFunction() {
        Item[] items = new Item[] { new Item("default", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("default", app.items[0].name);
        assertEquals("default, -1, 0",app.items[0].toString());
    }

    @ParameterizedTest
    @MethodSource("fetchItemsWithZeroQuantity")
    public void testQualityWithZeroQuantity(Item item){
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(item.name+", "+item.sellIn+", "+ item.quality,app.items[0].toString());
        assertEquals(0,item.quality);
    }

    @ParameterizedTest
    @MethodSource("fetchItemsWithQuantityAlwaysMoreThanZero")
    public void testQualityIncreaseWhenItsAfterSellIn(Item item){
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(item.name+", "+item.sellIn+", "+ item.quality,app.items[0].toString());
        assertEquals(3,item.quality);
    }


    @Test
    public void testNormalItemBeforeSellDate() {
        Item item = new Item("Normal Item", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();
        assertEquals("Normal Item", item.name);
        assertEquals(9, item.sellIn);
        assertEquals(19, item.quality);
    }
    @Test
    public void testNormalItemOnSellDate() {
        Item item = new Item("Normal Item", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals( -1, item.sellIn);
        assertEquals(18, item.quality);
    }
    @Test
    public void testNormalItemAfterSellDate() {
        Item item = new Item("Normal Item", -1, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals( -2, item.sellIn);
        assertEquals(18, item.quality);
    }

    @Test
    public void testAgedBrieBeforeSellDate() {
        Item item = new Item("Aged Brie", 10, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(9, item.sellIn);
        assertEquals(21, item.quality);
    }
    @Test
    public void testAgedBrieOnSellDate() {
        Item item = new Item("Aged Brie", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(22, item.quality);
    }
    @Test
    public void testAgedBrieAfterSellDate() {
        Item item = new Item("Aged Brie", -1, 22);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(-2, item.sellIn);
        assertEquals(24, item.quality);
    }

    @Test
    public void testBackstagePassesLongBeforeSellDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(14, item.sellIn);
        assertEquals(21, item.quality);
    }
    @Test
    public void testBackstagePassesLongOnSellDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }
    @Test
    public void testBackstagePassesLongAfterSellDate() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(-2, item.sellIn);
        assertEquals(0, item.quality);
    }

    @Test
    public void testSulfurasBeforeSellDate() {
       Item item = new Item("Sulfuras, Hand of Ragnaros", 20, 80);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(20, item.sellIn);
        assertEquals(80, item.quality);
    }
    @Test
    public void testSulfurasOnSellDate() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(0, item.sellIn);
        assertEquals(80, item.quality);
    }
    @Test
    public void testSulfurasAfterSellDate() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", -9, 80);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(-9, item.sellIn);
        assertEquals(80, item.quality);
    }

    @Test
    public void testConjuredItemsBeforeSellDate() {
        Item item = new Item("Conjured", 3, 6);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();
        assertEquals(2, item.sellIn);
        assertEquals(4, item.quality);
    }
    @Test
    public void testConjuredItemsOnSellDate() {
        Item item = new Item("Conjured", 0, 4);
        GildedRose app = new GildedRose(new Item[]{item});

        app.updateQuality();
        assertEquals(-1, item.sellIn);
        assertEquals(0, item.quality);
    }
    @Test
    public void testConjuredItemsAfterSellDate() {
        Item item = new Item("Conjured", -1, 10);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        assertEquals(-2, item.sellIn);
        assertEquals(6, item.quality);
    }
}
