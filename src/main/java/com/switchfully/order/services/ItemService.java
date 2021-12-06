package com.switchfully.order.services;

import com.switchfully.order.services.dto.CreateItemDTO;
import com.switchfully.order.services.dto.ItemDTO;

public interface ItemService {
    ItemDTO saveItem(CreateItemDTO createItemDTO);
}
