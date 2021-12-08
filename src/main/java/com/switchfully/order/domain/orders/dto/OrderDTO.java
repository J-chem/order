package com.switchfully.order.domain.orders.dto;

import com.switchfully.order.domain.orders.ItemGroup;
import com.switchfully.order.domain.valueobjects.Currency;
import com.switchfully.order.domain.valueobjects.Price;

import java.util.Set;

import static com.switchfully.order.domain.valueobjects.Currency.EUR;

public class OrderDTO {

    private String orderId;
    private String userId;
    private Set<ItemGroup> itemGroups;
    private Price totalPrice;

    public Set<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }

    public Price getTotalPrice() {
        return totalPrice;
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

    public OrderDTO setTotalPrice(Set<ItemGroup> itemGroups) {
        this.totalPrice = new Price(itemGroups.stream()
                .map(item -> item.getPrice().getPrice() * item.getAmount())
                .reduce(0.0, Double::sum),
                EUR);
        return this;
    }
}
