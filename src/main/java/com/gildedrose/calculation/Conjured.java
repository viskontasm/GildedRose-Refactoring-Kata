package com.gildedrose.calculation;

import com.gildedrose.Item;

public class Conjured extends RegularItem {

    protected void updateQuality(Item item) {
        decreaseQuality(item);
        decreaseQuality(item);
    }

    protected void updateQualityAfterSellIn(Item item) {
        decreaseQuality(item);
    }
}
