package com.switchfully.order.services.dto;

import com.switchfully.order.domain.ItemGroup;

import java.util.Set;

public class OrderDTO {

    private Set<ItemGroup> itemGroups;
    private String orderId;

    public OrderDTO setItemGroups(Set<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
        return this;
    }

    public OrderDTO setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }
}
