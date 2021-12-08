package com.switchfully.order.services;

import com.switchfully.order.domain.users.dto.CreateUserDTO;
import com.switchfully.order.domain.users.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(CreateUserDTO createUserDTO);

    List<UserDTO> getAllCustomers(String authorization);

    UserDTO getUserBy(String authorization, String email);
}
