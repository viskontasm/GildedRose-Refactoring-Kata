package com.gildedrose;

import com.gildedrose.calculation.AgedBrie;
import com.gildedrose.calculation.BackstagePass;
import com.gildedrose.calculation.RegularItem;
import com.gildedrose.calculation.Sulfuras;
import java.util.HashMap;
import java.util.Map;

class GildedRose {
    Item[] items;
    Map<String, RegularItem> itemList = new HashMap<>();

    public GildedRose(Item[] items) {
        this.items = items;
        itemList.put("Aged Brie", new AgedBrie());
        itemList.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePass());
        itemList.put("Sulfuras, Hand of Ragnaros", new Sulfuras());
    }

    public void updateQuality() {
        for (Item item : items) {
            RegularItem regularItem = itemList.get(item.name) == null ?  new RegularItem() : itemList.get(item.name);
            regularItem.updateItem(item);
        }
    }
}