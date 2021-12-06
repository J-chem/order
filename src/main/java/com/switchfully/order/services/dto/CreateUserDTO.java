package com.switchfully.order.services.dto;

import com.switchfully.order.domain.Address;
import com.switchfully.order.domain.TelephoneNumber;
import com.switchfully.order.security.Role;

import java.util.Objects;

public class CreateUserDTO {
    private final String firstName;
    private final String lastName;
    private final Address address;
    private final String email;
    private final TelephoneNumber telephoneNumber;

    private final Role role;

    public CreateUserDTO(String firstName, String lastName, Address address, String email, TelephoneNumber telephoneNumber, Role role) {
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.address = Objects.requireNonNull(address);
        this.email = Objects.requireNonNull(email);
        this.telephoneNumber = Objects.requireNonNull(telephoneNumber);
        this.role = role;
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

}
