package com.switchfully.order.api;

import com.switchfully.order.services.OrderService;
import com.switchfully.order.domain.orders.dto.CreateItemGroupDTO;
import com.switchfully.order.domain.orders.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "orders", produces = "application/json")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // POST
    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO saveOrder(@RequestBody List<CreateItemGroupDTO> createItemGroupDTO,
                       @RequestHeader String authorization) {
        logger.info("Orders: save order");
        return orderService.save(authorization, createItemGroupDTO);
    }

}
