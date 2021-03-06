package com.switchfully.order.security;

import java.util.List;

import static com.switchfully.order.security.Features.*;

public enum Role {
    ADMIN(List.of(ADD_ITEM, UPDATE_ITEM, GET_ALL_CUSTOMERS)),
    CUSTOMER(List.of(ORDER_ITEM, GET_MY_ORDERS));

    private final List<Features> listOfFeatures;

    Role(List<Features> listFeatures) {
        listOfFeatures = listFeatures;
    }

    public List<Features> getListOfFeatures() {
        return listOfFeatures;
    }
}
