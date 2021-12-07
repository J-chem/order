package com.switchfully.order.services;

import com.switchfully.order.domain.Item;
import com.switchfully.order.domain.ItemGroup;
import com.switchfully.order.domain.Order;
import com.switchfully.order.repositories.ItemRepository;
import com.switchfully.order.repositories.OrderRepository;
import com.switchfully.order.services.dto.CreateItemGroupDTO;
import com.switchfully.order.services.dto.OrderDTO;
import com.switchfully.order.services.mappers.ItemGroupMapper;
import com.switchfully.order.services.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final Order order;

    public DefaultOrderService(OrderRepository orderRepository,
                               ItemRepository itemRepository,
                               Order order) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.order = order;
    }

    @Override
    public OrderDTO save() {
        orderRepository.save(order);
        OrderDTO orderDTO = OrderMapper.map(order);
        return orderDTO;
    }

    @Override
    public LocalDate calculateShippingDate(int stock, int ordered) {
        return (ordered <= stock) ? LocalDate.now().plusDays(1) : LocalDate.now().plusWeeks(1);
    }

    @Override
    public void addItemGroup(CreateItemGroupDTO createItemGroupDTO) {
        Item item = itemRepository.findById(createItemGroupDTO.getItemId());
        LocalDate shippingDate = calculateShippingDate(item.getStock(), createItemGroupDTO.getAmount());
        ItemGroup itemGroup = ItemGroupMapper.map(createItemGroupDTO, shippingDate);
        order.addItem(itemGroup);
    }

}