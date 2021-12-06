package com.switchfully.order.api;

import com.switchfully.order.security.Features;
import com.switchfully.order.services.ItemService;
import com.switchfully.order.services.SecurityService;
import com.switchfully.order.services.dto.CreateItemDTO;
import com.switchfully.order.services.dto.ItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "items", produces = "application/json")
public class ItemController {

    private final ItemService itemService;
    private final SecurityService securityService;

    public ItemController(ItemService itemService, SecurityService securityService) {
        this.itemService = itemService;
        this.securityService = securityService;
    }

    @PostMapping(path = "postItem", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO saveItem(@RequestBody CreateItemDTO createItemDTO,
                            @RequestHeader String authorization) {
        securityService.validateAuthorization(authorization, Features.ADD_ITEM);
        return itemService.saveItem(createItemDTO);
    }
}
