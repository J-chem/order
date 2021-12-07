package com.switchfully.order.repositories;

import com.switchfully.order.domain.Item;

import java.util.Optional;

public interface ItemRepository {
    Item saveItem(Item item);
    Item findById(String itemId);
}
