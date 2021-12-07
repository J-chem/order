package com.switchfully.order.services.mappers;

import com.switchfully.order.domain.Order;
import com.switchfully.order.services.dto.OrderDTO;

public class OrderMapper {

    public static OrderDTO map(Order order) {
        // TODO
        return new OrderDTO()
                .setOrderId(order.getOrderId());

    }
}
