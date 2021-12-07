package com.switchfully.order.repositories;

import com.switchfully.order.domain.Order;

public interface OrderRepository {
    void save(Order order);
}
