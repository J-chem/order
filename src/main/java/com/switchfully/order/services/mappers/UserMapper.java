package com.switchfully.order.services.mappers;

import com.switchfully.order.domain.User;
import com.switchfully.order.services.dto.CreateUserDTO;
import com.switchfully.order.services.dto.UserDTO;

import java.util.List;

public class UserMapper {

    public static User map(CreateUserDTO createUserDTO) {
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

    public static UserDTO map(User returnedUser) {
        return new UserDTO(
                returnedUser.getId(),
                returnedUser.getFirstName(),
                returnedUser.getLastName(),
                returnedUser.getRole());
    }

    public static List<UserDTO> map(List<User> users) {
        return users.stream()
                .map(UserMapper::map)
                .toList();
    }
}
