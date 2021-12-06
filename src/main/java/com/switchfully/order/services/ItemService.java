package com.switchfully.order.services;

import com.switchfully.order.domain.Item;
import com.switchfully.order.services.dto.CreateItemDTO;

public interface ItemService {
    void saveItem(CreateItemDTO createItemDTO);
}
