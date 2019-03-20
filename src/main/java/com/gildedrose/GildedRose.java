package com.gildedrose;

import com.gildedrose.calculation.*;

import java.util.HashMap;
import java.util.Map;

class GildedRose {

    private Map<String, RegularItem> itemList = new HashMap<>();

    public GildedRose() {
        itemList.put("Aged Brie", new AgedBrie());
        itemList.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePass());
        itemList.put("Sulfuras, Hand of Ragnaros", new Sulfuras());
        itemList.put("Conjured Mana Cake", new Conjured());
    }

    public void updateQuality(Item item) {
        RegularItem regularItem = itemList.get(item.name) == null ?  new RegularItem() : itemList.get(item.name);
        regularItem.updateItem(item);
    }
}