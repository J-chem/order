package com.switchfully.order.repositories;

import com.switchfully.order.domain.orders.Order;
import com.switchfully.order.domain.orders.dto.OrderDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DefaultOrderRepository implements OrderRepository {

    private final ConcurrentHashMap<String, Order> orders;

    public DefaultOrderRepository() {
        this.orders = new ConcurrentHashMap<>() ;
    }

    @Override
    public Order placeOrder(Order order) {
        orders.put(order.getOrderId(), order);
        return order;
    }

    @Override
    public List<Order> getOrdersByCustomer(String id) {
        return orders.values().stream()
                .filter(order -> order.getUserId().equals(id))
                .toList();
    }
}
