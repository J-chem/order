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
    private final ItemMapper itemMapper;

    public DefaultItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemDTO saveItem(CreateItemDTO createItemDTO) {
        Item item = itemMapper.mapDTOToItem(createItemDTO);
        Item savedItem = itemRepository.saveItem(item);
        return itemMapper.mapItemToDTO(savedItem);
    }
}
