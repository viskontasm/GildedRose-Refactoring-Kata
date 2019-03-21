package com.gildedrose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableElasticsearchRepositories
public class GildedRoseApplication {
    public static void main(String... args) {
        SpringApplication.run(GildedRoseApplication.class, args);
    }
}
