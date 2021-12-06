package com.switchfully.order.repositories;

import com.switchfully.order.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DefaultItemRepository implements ItemRepository {

    private final ConcurrentHashMap<String, Item> stockItems;

    public DefaultItemRepository() {
        stockItems = new ConcurrentHashMap<>();
    }

    @Override
    public Item saveItem(Item item) {
        stockItems.put(item.getId(), item);
        return item;
    }
}
