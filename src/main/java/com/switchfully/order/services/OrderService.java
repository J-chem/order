package com.switchfully.order.services;

import com.switchfully.order.services.dto.CreateItemGroupDTO;
import com.switchfully.order.services.dto.OrderDTO;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {

    OrderDTO save(String authorization, List<CreateItemGroupDTO> createItemGroupDTO);

    default LocalDate calculateShippingDate(int stock, int ordered) {
        return (ordered <= stock) ?
                LocalDate.now().plusDays(1) :
                LocalDate.now().plusWeeks(1);
    }
}
