package com.switchfully.order.services;

import com.switchfully.order.services.dto.CreateUserDTO;
import com.switchfully.order.services.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO save(CreateUserDTO createUserDTO);

    List<UserDTO> getAllCustomers(String authorization);

    UserDTO getUserBy(String authorization, String email);
}
