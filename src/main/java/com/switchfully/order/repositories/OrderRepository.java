package com.switchfully.order.repositories;

import com.switchfully.order.domain.Order;

public interface OrderRepository {
    Order save(Order order);
}
