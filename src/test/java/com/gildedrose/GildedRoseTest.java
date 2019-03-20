package com.gildedrose;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.IntStream;

public class GildedRoseTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void foo() {
        Item item = new Item("foo", 0, 0);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals("foo", item.name);
    }

    @Test
    public void sellin_decreases_by_1() {
        Item item =  new Item("foo", 2, 2);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(1, item.sellIn);
    }

    @Test
    public void quality_decreases_by_1() {
        Item item = new Item("foo", 1, 2);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(1, item.quality);
    }

    @Test
    public void when_sellin_0_quality_decreases_by_2() {
        Item item = new Item("foo", 0, 3);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(1, item.quality);
    }

    @Test
    public void quality_degrades_twice_as_fast_after_sellin_passed() {
        Item item = new Item("foo", 0, 3);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(1, item.quality);
    }

    @Test
    public void quality_is_never_negative() {
        Item item = new Item("foo", 2, 0);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(0, item.quality);
    }

    @Test
    public void aged_brie_increases_in_quality() {
        Item item = new Item("Aged Brie", 1, 1);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(2, item.quality);
    }

    @Test
    public void aged_brie_when_sellin_0_increases_in_quality_by_2() {
        Item item = new Item("Aged Brie", 0, 1);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(3, item.quality);
    }

    @Test
    public void aged_brie_quality_is_never_more_50() {
        Item item = new Item("Aged Brie", 1, 50);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(50, item.quality);
    }

    @Test
    public void sulfuras_sellin_never_alters() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 80);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(1, item.sellIn);
    }

    @Test
    public void sulfuras_quality_never_alters() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 1, 80);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(80, item.quality);
    }

    @Test
    public void backstage_passes_when_sellin_above_10_quality_increases_by_1() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 0);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(1, item.quality);
    }

    @Test
    public void backstage_passes_when_sellin_less_11_and_above_5_quality_inscreases_by_2() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 0);
        GildedRose app = new GildedRose();
        IntStream.range(1, 6).forEach(i -> {
            app.updateQuality(item);
            assertEquals(i*2, item.quality);
        });
    }

    @Test
    public void backstage_passes_when_sellin_less_6_quality_increases_by_3() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0);
        GildedRose app = new GildedRose();
        IntStream.range(1, 6).forEach(i -> {
            app.updateQuality(item);
            assertEquals(i*3, item.quality);
        });
    }

    @Test
    public void backstage_passes_when_sellin_0_quality_becomes_0() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(0, item.quality);
    }

    @Test
    public void backstage_passes_quality_is_never_more_50() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 1, 50);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(50, item.quality);
    }

    @Test
    public void conjured_quality_decreases_by_2() {
        Item item = new Item("Conjured Mana Cake", 1, 3);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(1, item.quality); //TODO fix this test
    }

    @Test
    public void sellin_becomes_negative_1() {
        Item item = new Item("foo", 0, 0);
        GildedRose app = new GildedRose();
        app.updateQuality(item);
        assertEquals(-1, item.sellIn);
    }

    @Test
    public void golden_master_test() {
        TextTestFixture test = new TextTestFixture();
        test.printOutput(new String[] {"19"});

        String expectedOutput = test.readFromFile("golden-master-sample.txt");

        assertEquals(expectedOutput, outContent.toString());
    }
}
