package com.switchfully.order.api;


import com.switchfully.order.services.UserService;
import com.switchfully.order.domain.users.dto.CreateUserDTO;
import com.switchfully.order.domain.users.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "users", produces = "application/json")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllCustomers(@RequestHeader String authorization) {
        logger.info("Users: get all customers");
        return userService.getAllCustomers(authorization);
    }

    @GetMapping(path = "/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserBy(@PathVariable String email,
                             @RequestHeader String authorization) {
        logger.info("Users: get users by");
        return userService.getUserBy(authorization, email);
    }

    @PostMapping(path = "registerCustomer", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO registerCustomer(@RequestBody CreateUserDTO createUserDTO) {
        logger.info("Users: create customer account");
        return userService.save(createUserDTO);
    }


}
