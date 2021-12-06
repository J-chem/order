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
    private final UserMapper userMapper;

    public DefaultUserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(CreateUserDTO createUserDTO) {
        User toBeSavedUser = userMapper.mapDTOtoUSER(createUserDTO);
        User returnedUser = userRepository.saveUser(toBeSavedUser);
        return userMapper.mapUSERtoDTO(returnedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
//        List<User> users = userRepository
        return null;
    }
}
