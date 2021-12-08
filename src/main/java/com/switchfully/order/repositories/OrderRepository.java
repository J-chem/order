package com.switchfully.order.repositories;

import com.switchfully.order.domain.orders.Order;

public interface OrderRepository {
    Order save(Order order);
}
