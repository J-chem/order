package com.switchfully.order.services.mappers;

import com.switchfully.order.domain.Item;
import com.switchfully.order.services.dto.CreateItemDTO;
import com.switchfully.order.services.dto.ItemDTO;
import org.springframework.stereotype.Component;

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
