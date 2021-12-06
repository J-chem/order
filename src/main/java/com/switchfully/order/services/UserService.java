package com.switchfully.order.services;

import com.switchfully.order.services.dto.CreateUserDTO;
import com.switchfully.order.services.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(CreateUserDTO createUserDTO);
    List<UserDTO> getAllUsers();
}
