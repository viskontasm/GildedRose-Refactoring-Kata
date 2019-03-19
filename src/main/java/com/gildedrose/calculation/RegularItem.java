package com.gildedrose.calculation;

import com.gildedrose.Item;

public class RegularItem {

    public void updateItem(Item item) {
        updateQuality(item);
        updateSellIn(item);
        if (item.sellIn < 0) {
            updateQualityAfterSellIn(item);
        }
    }

    protected void updateQuality(Item item) {
        decreaseQuality(item);
    }

    protected void updateQualityAfterSellIn(Item item) {
        decreaseQuality(item);
    }

    protected void updateSellIn(Item item) {
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
