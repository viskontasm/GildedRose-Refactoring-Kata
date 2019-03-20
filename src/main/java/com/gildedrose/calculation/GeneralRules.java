package com.gildedrose.calculation;

import com.gildedrose.Item;

public class GeneralRules {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    public boolean isAboveMinQuality(Item item) {
        return item.quality > MIN_QUALITY;
    }

    public boolean isBelowMaxQuality(Item item) {
        return item.quality < MAX_QUALITY;
    }

    public boolean isBellowSellInThreshold(Item item, int sellInThreshold) {
        return item.sellIn < sellInThreshold;
    }
}
