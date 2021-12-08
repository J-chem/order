package com.switchfully.order.repositories;

import com.switchfully.order.domain.items.Item;

public interface ItemRepository {
    Item saveItem(Item item);
    Item findById(String itemId);
}
