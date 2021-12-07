package com.switchfully.order.services;

import com.switchfully.order.domain.Item;
import com.switchfully.order.domain.ItemGroup;
import com.switchfully.order.domain.Order;
import com.switchfully.order.domain.User;
import com.switchfully.order.repositories.ItemRepository;
import com.switchfully.order.repositories.OrderRepository;
import com.switchfully.order.security.Features;
import com.switchfully.order.services.dto.CreateItemGroupDTO;
import com.switchfully.order.services.dto.OrderDTO;
import com.switchfully.order.services.mappers.ItemGroupMapper;
import com.switchfully.order.services.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final SecurityService securityService;
    private final Order order;

    public DefaultOrderService(OrderRepository orderRepository,
                               ItemRepository itemRepository,
                               SecurityService securityService, Order order) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.securityService = securityService;
        this.order = order;
    }

    @Override
    public int addItemGroup(String authorization, CreateItemGroupDTO createItemGroupDTO) {
        securityService.validateAuthorization(authorization, Features.ORDER_ITEM);

        Item item = itemRepository.findById(createItemGroupDTO.getItemId());
        LocalDate shippingDate = calculateShippingDate(item.getStock(), createItemGroupDTO.getAmount());

        ItemGroup itemGroup = ItemGroupMapper.map(createItemGroupDTO, shippingDate);
        order.addItem(itemGroup);
        return itemGroup.getAmount() * item.getPrice();
    }

    @Override
    public OrderDTO save(String authorization) {
        User user = securityService.validateAuthorization(authorization, Features.ORDER_ITEM);
        order.setUserId(user.getId());
        Order savedOrder = orderRepository.save(order);
        OrderDTO orderDTO = OrderMapper.map(savedOrder);
        return orderDTO;
    }

}