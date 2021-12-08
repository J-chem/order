package com.switchfully.order.domain.items.mappers;

import com.switchfully.order.domain.items.Item;
import com.switchfully.order.domain.items.dto.CreateItemDTO;
import com.switchfully.order.domain.items.dto.ItemDTO;

public class ItemMapper {

    public static Item map(CreateItemDTO createItemDTO) {
        return new Item(
                createItemDTO.getName(),
                createItemDTO.getDescription(),
                createItemDTO.getPrice(),
                createItemDTO.getAmount()
        );
    }

    public static ItemDTO map(Item item) {
        return new ItemDTO.ItemDTOBuilder()
                .withId(item.getId())
                .withName(item.getName())
                .withDescription(item.getDescription())
                .withPrice(item.getPrice())
                .withAmount(item.getStock())
                .build();
    }
}
