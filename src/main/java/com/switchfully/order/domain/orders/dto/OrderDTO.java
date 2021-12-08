package com.switchfully.order.domain.orders.dto;

import com.switchfully.order.domain.orders.ItemGroup;

import java.util.Set;

public class OrderDTO {

    private String orderId;
    private String userId;
    private Set<ItemGroup> itemGroups;

    public Set<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public OrderDTO setItemGroups(Set<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
        return this;
    }

    public OrderDTO setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public OrderDTO setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
