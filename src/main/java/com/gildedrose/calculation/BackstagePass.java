package com.gildedrose.calculation;

import com.gildedrose.Item;

public class BackstagePass extends RegularItem{

    protected void updateQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
    }

    protected void updateQualityAfterSellIn(Item item) {
        item.quality = 0;
    }
}
