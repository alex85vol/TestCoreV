package com.corevalue.test.data;

//region Intefaces
interface IPurchasePrice {
    IDownPayment setPurchasePrice(long purchasePrice);
}

interface  IDownPayment {
    IAmortization setDownPayment(long downPayment);
}

interface IAmortization {
    IPaymentFrequency setAmortization(int amortization);
}

interface IPaymentFrequency {
    IInterestRate setPaymentFrequency(String paymentFrequency);
}

interface IInterestRate {
    ICalculatedPayments setInterestRate(double interestRate);
}

interface ICalculatedPayments {
    IBuild setCalculatedPayments(double calculatedPayments);
}

interface IBuild {
    User build();
}
//endregion

public class User implements IPurchasePrice, IDownPayment, IAmortization,
        IPaymentFrequency, IInterestRate, ICalculatedPayments, IBuild, IUser{

    //region User Data field
    private long purchasePrice;
    private long downPayment;
    private int amortization;
    private String paymentFrequency;
    private double interestRate;
    private double calculatedPayments;
    //endregion

    private User(){}

    public static IPurchasePrice get() {return new User();}


    //region Setters
    public IDownPayment setPurchasePrice(long purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public IAmortization setDownPayment(long downPayment) {
        this.downPayment = downPayment;
        return this;
    }

    public IPaymentFrequency setAmortization(int amortization) {
        this.amortization = amortization;
        return this;
    }

    public IInterestRate setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
        return this;
    }

    public ICalculatedPayments setInterestRate(double interestRate) {
        this.interestRate = interestRate;
        return this;
    }

    public IBuild setCalculatedPayments(double calculatedPayments) {
        this.calculatedPayments = calculatedPayments;
        return this;
    }

    public User build() {
        return this;
    }
    //endregion


    //region Getters
    public long getPurchasePrice() {
        return purchasePrice;
    }

    public long getDownPayment() {
        return downPayment;
    }

    public int getAmortization() {
        return amortization;
    }

    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getCalculatedPayments() {
        return calculatedPayments;
    }
    //endregion
}

