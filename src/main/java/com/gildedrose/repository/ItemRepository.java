package com.gildedrose.repository;

import com.gildedrose.model.ItemEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ItemRepository extends ElasticsearchRepository<ItemEntity, String> {
}
