package com.switchfully.order.services;

import com.switchfully.order.domain.User;
import com.switchfully.order.repositories.UserRepository;
import com.switchfully.order.services.dto.CreateUserDTO;
import com.switchfully.order.services.dto.UserDTO;
import com.switchfully.order.services.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;

    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO save(CreateUserDTO createUserDTO) {
        User toBeSavedUser = UserMapper.mapDTOtoUSER(createUserDTO);
        User returnedUser = userRepository.saveUser(toBeSavedUser);
        return UserMapper.mapUSERtoDTO(returnedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        // TODO
//        List<User> users = userRepository
        return null;
    }
}
