package com.switchfully.order.services.mappers;

import com.switchfully.order.domain.Item;
import com.switchfully.order.services.dto.CreateItemDTO;
import com.switchfully.order.services.dto.ItemDTO;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item mapDTOToItem(CreateItemDTO createItemDTO) {
        return new Item(
                createItemDTO.getName(),
                createItemDTO.getDescription(),
                createItemDTO.getPrice(),
                createItemDTO.getAmount()
        );
    }

    public ItemDTO mapItemToDTO(Item item) {
        return new ItemDTO.ItemDTOBuilder()
                .withId(item.getId())
                .withName(item.getName())
                .withDescription(item.getDescription())
                .withPrice(item.getPrice())
                .withAmount(item.getAmount())
                .build();
    }
}
