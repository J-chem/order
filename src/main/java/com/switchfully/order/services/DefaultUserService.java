package com.switchfully.order.services;

import com.switchfully.order.domain.users.User;
import com.switchfully.order.repositories.UserRepository;
import com.switchfully.order.security.Features;
import com.switchfully.order.domain.users.dto.CreateUserDTO;
import com.switchfully.order.domain.users.dto.UserDTO;
import com.switchfully.order.domain.users.mappers.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final SecurityService securityService;

    public DefaultUserService(UserRepository userRepository, SecurityService securityService) {
        this.userRepository = userRepository;
        this.securityService = securityService;
    }

    @Override
    public UserDTO save(CreateUserDTO createUserDTO) {
        User toBeSavedUser = UserMapper.map(createUserDTO);
        User returnedUser = userRepository.saveUser(toBeSavedUser);
        return UserMapper.map(returnedUser);
    }

    @Override
    public List<UserDTO> getAllCustomers(String authorization) {
        securityService.validateAuthorization(authorization, Features.GET_ALL_CUSTOMERS);
        List<User> users = userRepository.getAllCustomers();
        return UserMapper.map(users);
    }

    @Override
    public UserDTO getUserBy(String authorization, String email) {
        securityService.validateAuthorization(authorization, Features.GET_ALL_CUSTOMERS);
        User user = userRepository.getUserBy(email);
        return UserMapper.map(user);
    }
}
