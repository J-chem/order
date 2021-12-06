package com.switchfully.order.security;

import java.util.List;

import static com.switchfully.order.security.Features.ADD_ITEM;

public enum Role {
    ADMIN(List.of(ADD_ITEM)),
    CUSTOMER(List.of());

    private final List<Features> listOfFeatures;

    Role(List<Features> listFeatures) {
        listOfFeatures = listFeatures;
    }

    public List<Features> getListOfFeatures() {
        return listOfFeatures;
    }
}
