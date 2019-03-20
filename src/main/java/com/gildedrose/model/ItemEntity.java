package com.gildedrose.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "item-index", type = "items")
public class ItemEntity {

    @Id
    private String id;
    public String name;
    public String sellIn;
    public String quality;

    public ItemEntity(){}

    public ItemEntity(
            String name,
            String sellIn,
            String quality
    ) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellIn() {
        return sellIn;
    }

    public void setSellIn(String sellIn) {
        this.sellIn = sellIn;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
