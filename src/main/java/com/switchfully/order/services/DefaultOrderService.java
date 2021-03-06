package com.switchfully.order.services;

import com.switchfully.order.domain.items.Item;
import com.switchfully.order.domain.orders.ItemGroup;
import com.switchfully.order.domain.orders.Order;
import com.switchfully.order.domain.orders.dto.OverviewDTO;
import com.switchfully.order.domain.orders.dto.OverviewOrderDTO;
import com.switchfully.order.domain.users.User;
import com.switchfully.order.repositories.ItemRepository;
import com.switchfully.order.repositories.OrderRepository;
import com.switchfully.order.security.Features;
import com.switchfully.order.domain.orders.dto.CreateItemGroupDTO;
import com.switchfully.order.domain.orders.dto.OrderDTO;
import com.switchfully.order.domain.orders.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final SecurityService securityService;

    public DefaultOrderService(OrderRepository orderRepository,
                               ItemRepository itemRepository,
                               SecurityService securityService) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.securityService = securityService;
    }

    @Override
    public OrderDTO placeOrder(String authorization, List<CreateItemGroupDTO> createItemGroupDTOList) {
        User user = securityService.validateAuthorization(authorization, Features.ORDER_ITEM);
        Set<ItemGroup> itemGroupSet = getItemGroups(createItemGroupDTOList);
        Order order = new Order(user.getId(), itemGroupSet);
        return OrderMapper.map(orderRepository.placeOrder(order));
    }

    private Set<ItemGroup> getItemGroups(List<CreateItemGroupDTO> createItemGroupDTOList) {
        return createItemGroupDTOList.stream()
                .map(this::mapDTOtoItemGroup)
                .collect(Collectors.toSet());
    }

    private ItemGroup mapDTOtoItemGroup(CreateItemGroupDTO ordered) {
        Item item = itemRepository.findById(ordered.getItemId());
        int orderedAmount = ordered.getAmount();
        LocalDate shippingDate = calculateShippingDate(item.getStock(), orderedAmount);
        return createItemGroup(ordered, item, orderedAmount, shippingDate);
    }

    private ItemGroup createItemGroup(CreateItemGroupDTO ordered, Item item, int orderedAmount, LocalDate shippingDate) {
        return new ItemGroup(
                ordered.getItemId(),
                orderedAmount,
                shippingDate,
                item.getPrice());
    }

    @Override
    public OverviewDTO getOrdersByCustomer(String authorization) {
        User customer = securityService.validateAuthorization(authorization, Features.GET_MY_ORDERS);
        List<Order> orders = orderRepository.getOrdersByCustomer(customer.getId());
        return new OverviewDTO(orders.stream()
                .map(order -> {
                    var itemGroups = order.getItemGroups();
                    var itemGroupsMappedToDTO = itemGroups.stream()
                            .map(itemGroup -> {
                                var item = itemRepository.findById(itemGroup.getItemId());
                                return OrderMapper.map(itemGroup, item);
                            }).collect(Collectors.toSet());
                    return new OverviewOrderDTO(order.getOrderId(), itemGroupsMappedToDTO);
                })
                .toList());
    }
}
