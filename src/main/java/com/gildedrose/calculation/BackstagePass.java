package com.gildedrose.calculation;

import com.gildedrose.Item;

public class BackstagePass extends RegularItem{

    private static final int THRESHOLD_11 = 11;
    private static final int THRESHOLD_6 = 6;

    protected void updateQuality(Item item) {
        increaseQuality(item);
        if (item.sellIn < THRESHOLD_11) {
            increaseQuality(item);
        }
        if (item.sellIn < THRESHOLD_6) {
            increaseQuality(item);
        }
    }

    protected void updateQualityAfterSellIn(Item item) {
        item.quality = 0;
    }
}
