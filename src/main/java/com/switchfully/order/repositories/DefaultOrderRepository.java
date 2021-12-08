package com.switchfully.order.repositories;

import com.switchfully.order.domain.orders.Order;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DefaultOrderRepository implements OrderRepository {

    private final ConcurrentHashMap<String, Order> orders;

    public DefaultOrderRepository() {
        this.orders = new ConcurrentHashMap<>() ;
    }

    @Override
    public Order save(Order order) {
        orders.put(order.getOrderId(), order);
        return order;
    }
}
