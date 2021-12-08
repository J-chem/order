package com.switchfully.order.repositories;

import com.switchfully.order.domain.items.Item;
import com.switchfully.order.exceptions.ItemNotFoundException;
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

    @Override
    public Item findById(String itemId) {
        Item result = stockItems.get(itemId);
        if (result == null) throw new ItemNotFoundException("Item not found");
        return result;
    }
}
