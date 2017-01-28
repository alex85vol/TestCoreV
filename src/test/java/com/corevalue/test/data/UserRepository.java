package com.corevalue.test.data;

/**
 * Created by ovo on 25.01.2017.
 */
public final class UserRepository {

    private UserRepository(){}

    public static User getStandardUser() {
        return User.get()
                .setPurchasePrice(500000)
                .setDownPayment(50000)
                .setAmortization(15)
                .setPaymentFrequency("Weekly")
                .setInterestRate(5.00)
                .setCalculatedPayments(836.75)
                .build();
    }
}
