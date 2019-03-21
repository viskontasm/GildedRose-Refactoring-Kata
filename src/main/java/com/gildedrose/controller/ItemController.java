package com.gildedrose.controller;

import com.gildedrose.Item;
import com.gildedrose.repository.ItemRepository;
import com.gildedrose.service.ItemUpdater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemUpdater itemUpdater;

    @Autowired
    public ItemController(ItemRepository itemRepository,
                          ItemUpdater itemUpdater) {
        this.itemRepository = itemRepository;
        this.itemUpdater = itemUpdater;
    }

    @RequestMapping(value = "/items")
    public List<Item> getItems()  {
        return StreamSupport.stream(itemRepository
                .findAll()
                .spliterator(),true)
                    .sorted(Comparator.comparing(o -> o.getId()))
                    .map(i -> new Item(i.name,
                            Integer.parseInt(i.sellIn),
                            Integer.parseInt(i.quality)))
                    .collect(Collectors.toList());

    }

    @RequestMapping(value = "/update")
    public void updateItems()  {
        itemUpdater.updateItems();
    }
}
