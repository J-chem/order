package com.switchfully.order.domain.users;

import java.util.Objects;

public class Address {
    private final String streetName;
    private final String streetNumber;
    private final String postalCode;
    private final String city;

    public Address(String streetName, String streetNumber, String postalCode, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }
}
