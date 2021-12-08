package com.switchfully.order.domain.orders;

import com.switchfully.order.domain.orders.ItemGroup;

import java.util.*;

public class Order {

    private final String orderId;
    private final String userId;
    private final Set<ItemGroup> itemGroups;

    public Order(String userId, Set<ItemGroup> itemGroups) {
        this.userId = userId;
        this.itemGroups = itemGroups;
        this.orderId = UUID.randomUUID().toString();

    }

    public String getOrderId() {
        return orderId;
    }

    public Set<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public String getUserId() {
        return userId;
    }

}
