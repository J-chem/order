package com.switchfully.order.repositories;

import com.switchfully.order.domain.items.Item;
import com.switchfully.order.domain.items.dto.ItemDTO;

public interface ItemRepository {
    Item saveItem(Item item);
    Item findById(String itemId);
    Item updateItem(Item item);
}
