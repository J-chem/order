package com.switchfully.order.services;

import com.switchfully.order.domain.Order;
import com.switchfully.order.services.dto.CreateItemGroupDTO;
import com.switchfully.order.services.dto.OrderDTO;

import java.time.LocalDate;

public interface OrderService {

    OrderDTO save();
    void addItemGroup(CreateItemGroupDTO createItemGroupDTO);
    LocalDate calculateShippingDate(int stock, int ordered);
}
