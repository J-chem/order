package com.switchfully.order.domain.orders.mappers;

import com.switchfully.order.domain.items.Item;
import com.switchfully.order.domain.orders.ItemGroup;
import com.switchfully.order.domain.orders.Order;
import com.switchfully.order.domain.orders.dto.OrderDTO;
import com.switchfully.order.domain.orders.dto.OverviewItemGroupDTO;

public class OrderMapper {

    public static OrderDTO map(Order order) {
        return new OrderDTO()
                .setOrderId(order.getOrderId())
                .setUserId(order.getUserId())
                .setItemGroups(order.getItemGroups())
                .setTotalPrice(order.getItemGroups());
    }

    public static OverviewItemGroupDTO map(ItemGroup itemGroup, Item item) {
        return new OverviewItemGroupDTO()
                .setItemName(item.getName())
                .setAmount(itemGroup.getAmount())
                .setPrice(itemGroup.getPrice());
    }

}
