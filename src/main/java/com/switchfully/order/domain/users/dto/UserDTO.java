package com.switchfully.order.domain.users.dto;

import com.switchfully.order.security.Role;

public class UserDTO {
    private final String userId;
    private final String firstName;
    private final String lastName;
    private final Role role;

    public UserDTO(String userId, String firstName, String lastName, Role role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }
}
