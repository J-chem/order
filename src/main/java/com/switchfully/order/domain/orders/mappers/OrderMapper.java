package com.switchfully.order.domain.orders.mappers;

import com.switchfully.order.domain.orders.Order;
import com.switchfully.order.domain.orders.dto.OrderDTO;

public class OrderMapper {

    public static OrderDTO map(Order order) {
        return new OrderDTO()
                .setOrderId(order.getOrderId())
                .setUserId(order.getUserId())
                .setItemGroups(order.getItemGroups());
    }
}
