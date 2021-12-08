package com.switchfully.order.services;

import com.switchfully.order.domain.items.Item;
import com.switchfully.order.domain.items.dto.CreateItemDTO;
import com.switchfully.order.domain.items.dto.ItemDTO;

public interface ItemService {
    ItemDTO saveItem(String authorization, CreateItemDTO createItemDTO);

    Item findById(String itemId);
}
