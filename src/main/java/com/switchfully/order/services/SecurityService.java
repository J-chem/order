package com.switchfully.order.services;

import com.switchfully.order.domain.User;
import com.switchfully.order.security.Features;
import com.switchfully.order.security.Role;
import com.switchfully.order.security.SecureUser;

import java.util.Base64;

public interface SecurityService {
    User validateAuthorization(String authorization, Features feature);

    default boolean canHaveAccessTo(Features feature, Role role) {
        return role.getListOfFeatures().contains(feature);
    }

    default boolean doesPasswordMatch(String givenPassword, String userPassword) {
        return givenPassword.equals(userPassword);
    }

    default SecureUser getUsernamePassword(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        return new SecureUser(username, password);
    }
}
