package com.gildedrose.calculation;

import com.gildedrose.Item;

public class RegularItem {

    public void updateItem(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        updateQuality(item);
        updateSellIn(item);
        if (item.sellIn < 0) {
            updateQualityAfterSellIn(item);
        }
    }

    protected void updateQuality(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            increaseQuality(item);
            if (item.sellIn < 11) {
                increaseQuality(item);
            }
            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        } else {
            decreaseQuality(item);
        }
    }

    protected void updateQualityAfterSellIn(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else {
            decreaseQuality(item);
        }
    }

    private void updateSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    protected void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
