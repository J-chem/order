package com.switchfully.order.api;


import com.switchfully.order.services.SecurityService;
import com.switchfully.order.services.UserService;
import com.switchfully.order.services.dto.CreateUserDTO;
import com.switchfully.order.services.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users", produces = "application/json")
public class UserController {

    private final UserService userService;
    private final SecurityService securityService;

    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllCustomers(@RequestHeader String authorization) {
        return userService.getAllCustomers(authorization);
    }

    @GetMapping(path = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserBy(@PathVariable String email,
                             @RequestHeader String authorization) {
        return userService.getUserBy(authorization, email);
    }

    @PostMapping(path = "registerCustomer", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createCustomerAccount(@RequestBody CreateUserDTO createUserDTO) {
        return userService.save(createUserDTO);
    }
}
