package com.switchfully.order.services;

import com.switchfully.order.domain.orders.dto.CreateItemGroupDTO;
import com.switchfully.order.domain.orders.dto.OrderDTO;
import com.switchfully.order.domain.orders.dto.OverviewDTO;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    OrderDTO placeOrder(String authorization, List<CreateItemGroupDTO> createItemGroupDTO);

    OverviewDTO getOrdersByCustomer(String authorization);

    default LocalDate calculateShippingDate(int stock, int ordered) {
        return (ordered <= stock) ?
                LocalDate.now().plusDays(1) :
                LocalDate.now().plusWeeks(1);
    }
}
