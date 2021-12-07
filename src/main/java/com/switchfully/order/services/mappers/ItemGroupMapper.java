package com.switchfully.order.services.mappers;

import com.switchfully.order.domain.ItemGroup;
import com.switchfully.order.services.dto.CreateItemGroupDTO;

import java.time.LocalDate;

public class ItemGroupMapper {

    public static ItemGroup map(CreateItemGroupDTO createItemGroupDTO, LocalDate shippingDate) {
        return new ItemGroup(createItemGroupDTO.getItemId(), createItemGroupDTO.getAmount(), shippingDate);
    }
}
