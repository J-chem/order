package com.switchfully.order.services.mappers;

import com.switchfully.order.domain.User;
import com.switchfully.order.services.dto.CreateUserDTO;
import com.switchfully.order.services.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User mapDTOtoUSER(CreateUserDTO createUserDTO) {
        return new User(
                createUserDTO.getFirstName(),
                createUserDTO.getLastName(),
                createUserDTO.getEmail(),
                createUserDTO.getAddress(),
                createUserDTO.getTelephoneNumber(),
                createUserDTO.getRole(),
                createUserDTO.getUsername(),
                createUserDTO.getPassword());
    }

    public UserDTO mapUSERtoDTO(User returnedUser) {
        return new UserDTO(
                returnedUser.getId(),
                returnedUser.getFirstName(),
                returnedUser.getLastName(),
                returnedUser.getRole());
    }
}
