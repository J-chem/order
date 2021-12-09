package com.switchfully.order.services;

import com.switchfully.order.domain.items.Item;
import com.switchfully.order.domain.items.dto.UpdateItemDTO;
import com.switchfully.order.repositories.ItemRepository;
import com.switchfully.order.domain.items.dto.CreateItemDTO;
import com.switchfully.order.domain.items.dto.ItemDTO;
import com.switchfully.order.domain.items.mappers.ItemMapper;
import org.springframework.stereotype.Service;

import static com.switchfully.order.security.Features.*;

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
        securityService.validateAuthorization(authorization, ADD_ITEM);
        Item item = ItemMapper.map(createItemDTO);
        Item savedItem = itemRepository.saveItem(item);
        return ItemMapper.map(savedItem);
    }

    @Override
    public ItemDTO updateItem(String authorization, String itemId, UpdateItemDTO updateItemDTO) {
        securityService.validateAuthorization(authorization, UPDATE_ITEM);
        Item item = itemRepository.findById(itemId);
        if (item != null) {
            if (updateItemDTO.getName() != null) {
                item.setName(updateItemDTO.getName());
            }
            if (updateItemDTO.getDescription() != null) {
                item.setDescription(updateItemDTO.getDescription());
            }
            if (updateItemDTO.getPrice() != null) {
                item.setPrice(updateItemDTO.getPrice());
            }
            if (updateItemDTO.getStock() != item.getStock()) {
                item.setStock(updateItemDTO.getStock());
            }
        }
        Item updatedItem = itemRepository.updateItem(item);
        return ItemMapper.map(updatedItem);
    }
}

