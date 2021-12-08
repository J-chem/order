package com.switchfully.order.domain.users;

import com.switchfully.order.domain.users.Address;
import com.switchfully.order.domain.users.TelephoneNumber;
import com.switchfully.order.security.Role;

import java.util.UUID;

public class User {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Address address;
    private final TelephoneNumber telephoneNumber;

    private Role role;
    private String username;
    private String password;

    public User(String firstName, String lastName, String email, Address address, TelephoneNumber telephoneNumber, Role role, String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public TelephoneNumber getTelephoneNumber() {
        return telephoneNumber;
    }

    public Role getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


}
