package com.switchfully.order.services;

import com.switchfully.order.domain.Item;
import com.switchfully.order.repositories.ItemRepository;
import com.switchfully.order.services.dto.CreateItemDTO;
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
    public void saveItem(CreateItemDTO createItemDTO) {
        Item item = itemMapper.mapDTOToItem(createItemDTO);
        itemRepository.saveItem(item);
    }
}
