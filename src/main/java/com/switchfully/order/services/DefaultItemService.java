package com.switchfully.order.services;

import com.switchfully.order.domain.Item;
import com.switchfully.order.repositories.ItemRepository;
import com.switchfully.order.services.dto.CreateItemDTO;
import com.switchfully.order.services.dto.ItemDTO;
import com.switchfully.order.services.mappers.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class DefaultItemService implements ItemService {

    private final ItemRepository itemRepository;

    public DefaultItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemDTO saveItem(CreateItemDTO createItemDTO) {
        Item item = ItemMapper.map(createItemDTO);
        Item savedItem = itemRepository.saveItem(item);
        return ItemMapper.map(savedItem);
    }

    @Override
    public Item findById(String itemId) {
        return itemRepository.findById(itemId);
    }
}

