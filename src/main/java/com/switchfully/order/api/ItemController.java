package com.switchfully.order.api;


import com.switchfully.order.services.ItemService;
import com.switchfully.order.services.dto.CreateItemDTO;
import com.switchfully.order.services.dto.ItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "items", produces = "application/json")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ItemDTO saveItem(@RequestBody CreateItemDTO createItemDTO,
                            @RequestHeader String authorization) {
        return itemService.saveItem(authorization, createItemDTO);
    }
}
