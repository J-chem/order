package com.switchfully.order.domain;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Order {

    private static final long serialVersionUID = 1L;

    private final Set<ItemGroup> itemGroups;
    private final String orderId;

    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.itemGroups = new LinkedHashSet<>();
    }

    public String getOrderId() {
        return orderId;
    }

    public Set<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public void addItem(ItemGroup itemGroup) {
        itemGroups.add(itemGroup);
    }
}
