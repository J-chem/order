package com.switchfully.order.services;

import com.switchfully.order.domain.users.User;
import com.switchfully.order.security.Features;

public interface SecurityService {
    User validateAuthorization(String authorization, Features feature);
}
