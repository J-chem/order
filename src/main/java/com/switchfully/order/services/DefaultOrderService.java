package com.switchfully.order.services;

import com.switchfully.order.domain.ItemGroup;
import com.switchfully.order.domain.Order;
import com.switchfully.order.domain.User;
import com.switchfully.order.repositories.ItemRepository;
import com.switchfully.order.repositories.OrderRepository;
import com.switchfully.order.security.Features;
import com.switchfully.order.services.dto.CreateItemGroupDTO;
import com.switchfully.order.services.dto.OrderDTO;
import com.switchfully.order.services.mappers.OrderMapper;
import org.springframework.stereotype.Service;

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
    public OrderDTO save(String authorization, List<CreateItemGroupDTO> createItemGroupDTOList) {

        User user = securityService.validateAuthorization(authorization, Features.ORDER_ITEM);

        Set<ItemGroup> itemGroupSet = createItemGroupDTOList.stream()
                .map(ordered -> {
                            var item = itemRepository.findById(ordered.getItemId());
                            var amount = ordered.getAmount();
                            var shippingDate = calculateShippingDate(item.getStock(), amount);
                            return
                            new ItemGroup(
                                    ordered.getItemId(),
                                    amount,
                                    shippingDate,
                                    amount * item.getPrice());
                        })
                .collect(Collectors.toSet());

        Order order = new Order(user.getId(), itemGroupSet);

        return OrderMapper.map(orderRepository.save(order));
    }

}