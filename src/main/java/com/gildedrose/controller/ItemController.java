package com.gildedrose.controller;

import com.gildedrose.Item;
import com.gildedrose.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @RequestMapping(value = "/items")
    public List<Item> getAllEmployees()  {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll()
                .forEach(e -> items.add(new Item(e.name,
                            Integer.parseInt(e.sellIn),
                            Integer.parseInt(e.quality))
                ));
        return items;
    }
}
