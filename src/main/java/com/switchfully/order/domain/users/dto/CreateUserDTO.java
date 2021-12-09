package com.switchfully.order.domain.users.dto;

import com.switchfully.order.domain.users.Address;
import com.switchfully.order.domain.users.TelephoneNumber;
import com.switchfully.order.security.Role;

import javax.validation.constraints.Email;
import java.util.Objects;

public class CreateUserDTO {
    private final String firstName;
    private final String lastName;
    private final Address address;
    @Email
    private final String email;
    private final TelephoneNumber telephoneNumber;

    private final Role role;
    private final String username;
    private final String password;


    public CreateUserDTO(String firstName, String lastName, String email, Address address, TelephoneNumber telephoneNumber, Role role, String username, String password) {
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.address = Objects.requireNonNull(address);
        this.email = Objects.requireNonNull(email);
        this.telephoneNumber = Objects.requireNonNull(telephoneNumber);
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
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
