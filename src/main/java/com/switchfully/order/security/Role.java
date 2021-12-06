package com.switchfully.order.security;

import java.util.List;

public enum Role {
    ADMIN(List.of()),
    CUSTOMER(List.of());

    private final List<Features> listOfFeatures;

    Role(List<Features> listFeatures) {
        listOfFeatures = listFeatures;
    }

    public List<Features> getListOfFeatures() {
        return listOfFeatures;
    }
}
