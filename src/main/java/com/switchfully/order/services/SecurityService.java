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
public class SecurityService {

    private final UserRepository userRepository;

    public SecurityService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

    private boolean canHaveAccessTo(Features feature, Role role) {
        return role.getListOfFeatures().contains(feature);
    }

    private boolean doesPasswordMatch(String givenPassword, String userPassword) {
        return givenPassword.equals(userPassword);
    }

    private SecureUser getUsernamePassword(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        return new SecureUser(username, password);
    }
}
