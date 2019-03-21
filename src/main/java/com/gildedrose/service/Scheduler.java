package com.gildedrose.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Scheduler {

    private static final Logger log = LoggerFactory.getLogger(Scheduler.class);
    private final ItemUpdater itemUpdater;

    @Autowired
    public Scheduler(ItemUpdater itemUpdater) {
        this.itemUpdater = itemUpdater;
    }

    @Scheduled(cron = "0 0 10 * * *")
    public void updateItems() {
        try {
            log.info("Items update scheduler started");
            itemUpdater.updateItems();
            log.info("Items update scheduler finished");
        } catch (Exception ex) {
            log.error("ERROR {}", ex.getMessage());
        }
    }
}
