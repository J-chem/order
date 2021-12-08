package com.switchfully.order.domain.users;

public class TelephoneNumber {
    private String prefixNumber;
    private String number;

    public TelephoneNumber(String prefixNumber, String number) {
//        assertTelephoneNumber(prefixNumber, number);
        this.prefixNumber = prefixNumber;
        this.number = number;
    }

    public String getTelephoneNumber() {
        return "0"  + prefixNumber + "/" + number;
    }

    // TODO: Write telephone number check


}
