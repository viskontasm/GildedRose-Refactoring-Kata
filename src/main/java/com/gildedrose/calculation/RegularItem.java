package com.gildedrose.calculation;

import com.gildedrose.Item;

public class RegularItem {

    protected GeneralRules generalRules;
    private static final int DEFAULT_THRESHOLD = 0;

    public void updateItem(Item item) {
        generalRules = new GeneralRules();
        updateQuality(item);
        updateSellIn(item);
        if (generalRules.isBellowSellInThreshold(item, DEFAULT_THRESHOLD)) {
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
        if (generalRules.isBelowMaxQuality(item)) {
            item.quality = item.quality + 1;
        }
    }

    protected void decreaseQuality(Item item) {
        if (generalRules.isAboveMinQuality(item)) {
            item.quality = item.quality - 1;
        }
    }
}
