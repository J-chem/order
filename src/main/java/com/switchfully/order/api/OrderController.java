package com.switchfully.order.api;

import com.switchfully.order.services.OrderService;
import com.switchfully.order.services.dto.CreateItemGroupDTO;
import com.switchfully.order.services.dto.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "orders", produces = "application/json")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // POST
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public int addItem(@RequestBody CreateItemGroupDTO createItemGroupDTO,
                       @RequestHeader String authorization) {
        return orderService.addItemGroup(authorization, createItemGroupDTO);
    }

    @PostMapping(path = "finishOrder")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO finishOrder(@RequestHeader String authorization) {
        return orderService.save(authorization);
    }
}
