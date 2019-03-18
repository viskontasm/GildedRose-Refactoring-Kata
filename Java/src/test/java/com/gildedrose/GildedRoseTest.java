package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void sellin_decreases_by_1() {
        Item[] items = new Item[] { new Item("foo", 2, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    public void quality_decreases_by_1() {
        Item[] items = new Item[] { new Item("foo", 1, 2) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void when_sellin_0_quality_decreases_by_2() {
        Item[] items = new Item[] { new Item("foo", 0, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void quality_degrades_twice_as_fast_after_sellin_passed() {
        Item[] items = new Item[] { new Item("foo", 0, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void quality_is_never_negative() {
        Item[] items = new Item[] { new Item("foo", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void aged_brie_increases_in_quality() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void aged_brie_when_sellin_0_increases_in_quality_by_2() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void aged_brie_quality_is_never_more_50() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void sulfuras_sellin_never_alters() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }

    @Test
    public void sulfuras_quality_never_alters() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void backstage_passes_when_sellin_above_10_quality_increases_by_1() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }

    @Test
    public void backstage_passes_when_sellin_less_11_and_above_5_quality_inscreases_by_2() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);
        app.updateQuality();
        assertNotEquals(12, app.items[0].quality);
        IntStream.range(0, 2).forEach(i -> app.updateQuality());
    }

    @Test
    public void backstage_passes_when_sellin_less_6_quality_increases_by_3() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(3, app.items[0].quality);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
        app.updateQuality();
        assertEquals(15, app.items[0].quality);
        app.updateQuality();
        assertNotEquals(18, app.items[0].quality);
    }

    @Test
    public void backstage_passes_when_sellin_0_quality_becomes_0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void backstage_passes_quality_is_never_more_50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void conjured_quality_decreases_by_2() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 1, 3) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality); //TODO fix this test
    }

    @Test
    public void sellin_becomes_negative_1() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }
}
