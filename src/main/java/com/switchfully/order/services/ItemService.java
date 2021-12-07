package com.switchfully.order.services;

import com.switchfully.order.domain.Item;
import com.switchfully.order.services.dto.CreateItemDTO;
import com.switchfully.order.services.dto.ItemDTO;

public interface ItemService {
    ItemDTO saveItem(String authorization, CreateItemDTO createItemDTO);

    Item findById(String itemId);
}
