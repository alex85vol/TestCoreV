package com.corevalue.test.data;

/**
 * Created by ovo on 25.01.2017.
 */
public interface IUser {

    long getPurchasePrice();
    long getDownPayment();
    int getAmortization();
    String getPaymentFrequency();
    double getInterestRate();
    double getCalculatedPayments();

}
