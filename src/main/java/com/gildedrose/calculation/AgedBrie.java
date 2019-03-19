package com.gildedrose.calculation;

import com.gildedrose.Item;

public class AgedBrie extends RegularItem {

    protected void updateQuality(Item item) {
        increaseQuality(item);
    }

    protected void updateQualityAfterSellIn(Item item) {
        increaseQuality(item);
    }
}
