package com.switchfully.order.repositories;

import com.switchfully.order.domain.Item;

public interface ItemRepository {
    void saveItem(Item item);
}
