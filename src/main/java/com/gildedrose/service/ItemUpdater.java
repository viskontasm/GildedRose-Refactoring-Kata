package com.gildedrose.service;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import com.gildedrose.model.ItemEntity;
import com.gildedrose.repository.ItemRepository;
import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

@Service
public class ItemUpdater {

    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);
    private final ItemRepository itemRepository;
    private final GildedRose gildedRose;

    public ItemUpdater(ItemRepository itemRepository,
                       GildedRose gildedRose) {
        this.itemRepository = itemRepository;
        this.gildedRose = gildedRose;
    }

    @Transactional
    public void updateItems() {
        log.info("--------Items updated asynchronously!-------");
        Collection<ItemEntity> itemEntities = IteratorUtils.toList(
                itemRepository.findAll().iterator());
        itemEntities.stream()
                .parallel()
                .map(this::updateItem)
                .map(CompletableFuture::join)
                .forEach(itemRepository::save);
    }

    private CompletableFuture<ItemEntity> updateItem(ItemEntity itemEntity) {
        return CompletableFuture.supplyAsync(() -> {
            Item item = new Item(
                itemEntity.getName(),
                Integer.valueOf(itemEntity.getSellIn()),
                Integer.valueOf(itemEntity.getQuality()));

            gildedRose.updateQuality(item);
            itemEntity.setSellIn(String.valueOf(item.sellIn));
            itemEntity.setQuality(String.valueOf(item.quality));
            log.info("Item updated: {}", item.name);
            return itemEntity;
        });
    }
}
