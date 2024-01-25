package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @ParameterizedTest
    @CsvSource({"1,-1,0", "2,-1,0", "5,-1,3"})
    void foo(int quality, int expectedSellIn, int expectedQuality) {
        Item[] items = new Item[] { new Item("foo", 0, quality) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo, "+expectedSellIn+", "+expectedQuality, app.items[0].toString());
    }
    @Test
    void agedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Aged Brie, -1, 2", app.items[0].toString());
    }

}
