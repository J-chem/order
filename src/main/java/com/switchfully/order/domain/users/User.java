package com.switchfully.order.domain.users;

import com.switchfully.order.domain.users.Address;
import com.switchfully.order.domain.users.TelephoneNumber;
import com.switchfully.order.security.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public class User {

    private final String id;
    @NotNull
    @NotBlank
    private final String firstName;
    @NotNull
    @NotBlank
    private final String lastName;
    @Email
    private final String email;
    @NotNull
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(email, user.email) && Objects.equals(address, user.address) && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, address, username);
    }
}
