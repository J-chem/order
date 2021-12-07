package com.switchfully.order.services;

import com.switchfully.order.domain.Item;
import com.switchfully.order.repositories.ItemRepository;
import com.switchfully.order.security.Features;
import com.switchfully.order.services.dto.CreateItemDTO;
import com.switchfully.order.services.dto.ItemDTO;
import com.switchfully.order.services.mappers.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultItemService implements ItemService {

    private final ItemRepository itemRepository;
    private final SecurityService securityService;

    public DefaultItemService(ItemRepository itemRepository, SecurityService securityService) {
        this.itemRepository = itemRepository;
        this.securityService = securityService;
    }

    @Override
    public ItemDTO saveItem(String authorization, CreateItemDTO createItemDTO) {
        securityService.validateAuthorization(authorization, Features.ADD_ITEM);
        Item item = ItemMapper.map(createItemDTO);
        Item savedItem = itemRepository.saveItem(item);
        return ItemMapper.map(savedItem);
    }

    @Override
    public Item findById(String itemId) {
        return itemRepository.findById(itemId);
    }
}

