package com.switchfully.order.repositories;

import com.switchfully.order.domain.orders.Order;
import com.switchfully.order.domain.orders.dto.OrderDTO;

import java.util.List;

public interface OrderRepository {
    Order placeOrder(Order order);

    List<Order> getOrdersByCustomer(String id);
}
