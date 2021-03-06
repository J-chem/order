package com.switchfully.order.api;


import com.switchfully.order.domain.items.dto.UpdateItemDTO;
import com.switchfully.order.services.ItemService;
import com.switchfully.order.domain.items.dto.CreateItemDTO;
import com.switchfully.order.domain.items.dto.ItemDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "items", produces = "application/json")

public class ItemController {

    private final Logger logger = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO saveItem(@Valid @RequestBody CreateItemDTO createItemDTO,
                            @RequestHeader String authorization) {
        logger.info("Items: save item");
        return itemService.saveItem(authorization, createItemDTO);
    }

    @PutMapping(path = "/{itemId}", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO updateItem(@PathVariable String itemId,
                              @RequestBody UpdateItemDTO updateItemDTO,
                              @RequestHeader String authorization) {
        logger.info("Items: updateItem");
        return itemService.updateItem(authorization, itemId, updateItemDTO);
    }
}
