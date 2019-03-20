package com.gildedrose.service;

import com.gildedrose.Item;
import com.gildedrose.model.ItemEntity;
import com.gildedrose.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class ElasticInitialLoader implements ApplicationListener<ApplicationReadyEvent> {

    private final ItemRepository itemRepository;
    Item[] items;

    @Autowired
    public ElasticInitialLoader(ItemRepository repository) {
        this.itemRepository = repository;
        items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6) };
    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        itemRepository.deleteAll();
        Arrays.stream(items)
                .forEach(this::saveToElastic);
    }

    private void saveToElastic(Item item) {
        itemRepository.save(
            new ItemEntity(item.name,
                           String.valueOf(item.sellIn),
                           String.valueOf(item.quality))
        );
    }
}