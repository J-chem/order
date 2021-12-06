package com.switchfully.order.services;

import com.switchfully.order.domain.User;
import com.switchfully.order.exceptions.UnauthorizedException;
import com.switchfully.order.exceptions.UnknownUserException;
import com.switchfully.order.exceptions.WrongPasswordException;
import com.switchfully.order.repositories.UserRepository;
import com.switchfully.order.security.Features;
import com.switchfully.order.security.Role;
import com.switchfully.order.security.SecureUser;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class DefaultSecurityService implements SecurityService {

    private final UserRepository userRepository;

    public DefaultSecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User validateAuthorization(String authorization, Features feature) {
        SecureUser usernamePassword = getUsernamePassword(authorization);
        User user = userRepository.getUser(usernamePassword.getUsername()).get();
        if(user == null) {
            throw new UnknownUserException();
        }
        if(!doesPasswordMatch(usernamePassword.getPassword(), user.getPassword())) {
            throw new WrongPasswordException();
        }
        if(!canHaveAccessTo(feature, user.getRole())) {
            throw new UnauthorizedException();
        }
        return user;
    }

}
